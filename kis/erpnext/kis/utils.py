# -*- coding: utf-8 -*-
# Copyright (c) 2018, earthians and contributors
# For license information, please see license.txt

from __future__ import unicode_literals
import math
import frappe
from frappe import _
from erpnext.kis.doctype.healthcare_settings.healthcare_settings import get_income_account

@frappe.whitelist()
def get_healthcare_services_to_invoice(patient, company):
	patient = frappe.get_doc('Patient', patient)
	items_to_invoice = []
	if patient:
		validate_customer_created(patient)
		# Customer validated, build a list of billable services
		items_to_invoice += get_appointments_to_invoice(patient, company)
		items_to_invoice += get_encounters_to_invoice(patient, company)
		items_to_invoice += get_clinical_procedures_to_invoice(patient, company)

		return items_to_invoice


def validate_customer_created(patient):
	if not frappe.db.get_value('Patient', patient.name, 'customer'):
		msg = _("Please set a Customer linked to the Patient")
		msg +=  " <b><a href='#Form/Patient/{0}'>{0}</a></b>".format(patient.name)
		frappe.throw(msg, title=_('Customer Not Found'))


def get_appointments_to_invoice(patient, company):
	appointments_to_invoice = []
	patient_appointments = frappe.get_list(
			'Patient Appointment',
			fields = '*',
			filters = {'patient': patient.name, 'company': company, 'invoiced': 0, 'status': ['not in', 'Cancelled']},
			order_by = 'appointment_date'
		)

	for appointment in patient_appointments:
		# Procedure Appointments
		if appointment.procedure_template:
			if frappe.db.get_value('Clinical Procedure Template', appointment.procedure_template, 'is_billable'):
				appointments_to_invoice.append({
					'reference_type': 'Patient Appointment',
					'reference_name': appointment.name,
					'service': appointment.procedure_template
				})
		# Consultation Appointments, should check fee validity
		else:
			if frappe.db.get_single_value('Healthcare Settings', 'enable_free_follow_ups') and \
				frappe.db.exists('Fee Validity Reference', {'appointment': appointment.name}):
					continue # Skip invoicing, fee validty present
			practitioner_charge = 0
			income_account = None
			service_item = None
			if appointment.practitioner:
				service_item, practitioner_charge = get_service_item_and_practitioner_charge(appointment)
				income_account = get_income_account(appointment.practitioner, appointment.company)
			appointments_to_invoice.append({
				'reference_type': 'Patient Appointment',
				'reference_name': appointment.name,
				'service': service_item,
				'rate': practitioner_charge,
				'income_account': income_account
			})

	return appointments_to_invoice


def get_encounters_to_invoice(patient, company):
	encounters_to_invoice = []
	encounters = frappe.get_list(
		'Patient Encounter',
		fields=['*'],
		filters={'patient': patient.name, 'company': company, 'invoiced': False, 'docstatus': 1}
	)
	if encounters:
		for encounter in encounters:
			if not encounter.appointment:
				practitioner_charge = 0
				income_account = None
				service_item = None
				if encounter.practitioner:
					service_item, practitioner_charge = get_service_item_and_practitioner_charge(encounter)
					income_account = get_income_account(encounter.practitioner, encounter.company)

				encounters_to_invoice.append({
					'reference_type': 'Patient Encounter',
					'reference_name': encounter.name,
					'service': service_item,
					'rate': practitioner_charge,
					'income_account': income_account
				})

	return encounters_to_invoice






def get_clinical_procedures_to_invoice(patient, company):
	clinical_procedures_to_invoice = []
	procedures = frappe.get_list(
		'Clinical Procedure',
		fields='*',
		filters={'patient': patient.name, 'company': company, 'invoiced': False}
	)
	for procedure in procedures:
		if not procedure.appointment:
			item, is_billable = frappe.get_cached_value('Clinical Procedure Template', procedure.procedure_template, ['item', 'is_billable'])
			if procedure.procedure_template and is_billable:
				clinical_procedures_to_invoice.append({
					'reference_type': 'Clinical Procedure',
					'reference_name': procedure.name,
					'service': item
				})

		# consumables
		if procedure.invoice_separately_as_consumables and procedure.consume_stock \
			and procedure.status == 'Completed' and not procedure.consumption_invoiced:

			service_item = get_healthcare_service_item('clinical_procedure_consumable_item')
			if not service_item:
				msg = _('Please Configure Clinical Procedure Consumable Item in ')
				msg += '''<b><a href='#Form/Healthcare Settings'>Healthcare Settings</a></b>'''
				frappe.throw(msg, title=_('Missing Configuration'))

			clinical_procedures_to_invoice.append({
				'reference_type': 'Clinical Procedure',
				'reference_name': procedure.name,
				'service': service_item,
				'rate': procedure.consumable_total_amount,
				'description': procedure.consumption_details
			})

	procedure_prescriptions = frappe.db.sql(
		'''
			SELECT
				pp.name, pp.procedure
			FROM
				`tabPatient Encounter` et, `tabProcedure Prescription` pp
			WHERE
				et.patient=%s
				and pp.parent=et.name
				and pp.procedure_created=0
				and pp.invoiced=0
				and pp.appointment_booked=0
		''', (patient.name), as_dict=1)

	for prescription in procedure_prescriptions:
		item, is_billable = frappe.get_cached_value('Clinical Procedure Template', prescription.procedure, ['item', 'is_billable'])
		if is_billable:
			clinical_procedures_to_invoice.append({
				'reference_type': 'Procedure Prescription',
				'reference_name': prescription.name,
				'service': item
			})

	return clinical_procedures_to_invoice



def get_practitioner_service_item(practitioner, service_item_field):
	return frappe.db.get_value('Healthcare Practitioner', practitioner, service_item_field)


def get_healthcare_service_item(service_item_field):
	return frappe.db.get_single_value('Healthcare Settings', service_item_field)


def get_practitioner_charge(practitioner, is_inpatient):
	if is_inpatient:
		practitioner_charge = frappe.db.get_value('Healthcare Practitioner', practitioner, 'inpatient_visit_charge')
	else:
		practitioner_charge = frappe.db.get_value('Healthcare Practitioner', practitioner, 'op_consulting_charge')
	if practitioner_charge:
		return practitioner_charge
	return False


def manage_invoice_submit_cancel(doc, method):
	if doc.items:
		for item in doc.items:
			if item.get('reference_dt') and item.get('reference_dn'):
				if frappe.get_meta(item.reference_dt).has_field('invoiced'):
					set_invoiced(item, method, doc.name)

	if method=='on_submit' and frappe.db.get_single_value('Healthcare Settings', 'create_lab_test_on_si_submit'):
		create_multiple('Sales Invoice', doc.name)


def set_invoiced(item, method, ref_invoice=None):
	invoiced = False
	if method=='on_submit':
		validate_invoiced_on_submit(item)
		invoiced = True

	if item.reference_dt == 'Clinical Procedure':
		if get_healthcare_service_item('clinical_procedure_consumable_item') == item.item_code:
			frappe.db.set_value(item.reference_dt, item.reference_dn, 'consumption_invoiced', invoiced)
		else:
			frappe.db.set_value(item.reference_dt, item.reference_dn, 'invoiced', invoiced)
	else:
		frappe.db.set_value(item.reference_dt, item.reference_dn, 'invoiced', invoiced)

	if item.reference_dt == 'Patient Appointment':
		if frappe.db.get_value('Patient Appointment', item.reference_dn, 'procedure_template'):
			dt_from_appointment = 'Clinical Procedure'
		else:
			dt_from_appointment = 'Patient Encounter'
		manage_doc_for_appointment(dt_from_appointment, item.reference_dn, invoiced)

	elif item.reference_dt == 'Lab Prescription':
		manage_prescriptions(invoiced, item.reference_dt, item.reference_dn, 'Lab Test', 'lab_test_created')

	elif item.reference_dt == 'Procedure Prescription':
		manage_prescriptions(invoiced, item.reference_dt, item.reference_dn, 'Clinical Procedure', 'procedure_created')


def validate_invoiced_on_submit(item):
	if item.reference_dt == 'Clinical Procedure' and get_healthcare_service_item('clinical_procedure_consumable_item') == item.item_code:
		is_invoiced = frappe.db.get_value(item.reference_dt, item.reference_dn, 'consumption_invoiced')
	else:
		is_invoiced = frappe.db.get_value(item.reference_dt, item.reference_dn, 'invoiced')
	if is_invoiced:
		frappe.throw(_('The item referenced by {0} - {1} is already invoiced').format(
			item.reference_dt, item.reference_dn))


def manage_prescriptions(invoiced, ref_dt, ref_dn, dt, created_check_field):
	created = frappe.db.get_value(ref_dt, ref_dn, created_check_field)
	if created:
		# Fetch the doc created for the prescription
		doc_created = frappe.db.get_value(dt, {'prescription': ref_dn})
		frappe.db.set_value(dt, doc_created, 'invoiced', invoiced)


def check_fee_validity(appointment):
	if not frappe.db.get_single_value('Healthcare Settings', 'enable_free_follow_ups'):
		return

	validity = frappe.db.exists('Fee Validity', {
		'practitioner': appointment.practitioner,
		'patient': appointment.patient,
		'valid_till': ('>=', appointment.appointment_date)
	})
	if not validity:
		return

	validity = frappe.get_doc('Fee Validity', validity)
	return validity


def manage_fee_validity(appointment):
	fee_validity = check_fee_validity(appointment)

	if fee_validity:
		if appointment.status == 'Cancelled' and fee_validity.visited > 0:
			fee_validity.visited -= 1
			frappe.db.delete('Fee Validity Reference', {'appointment': appointment.name})
		elif fee_validity.status == 'Completed':
			return
		else:
			fee_validity.visited += 1
			fee_validity.append('ref_appointments', {
				'appointment': appointment.name
			})
		fee_validity.save(ignore_permissions=True)
	else:
		fee_validity = create_fee_validity(appointment)
	return fee_validity


def manage_doc_for_appointment(dt_from_appointment, appointment, invoiced):
	dn_from_appointment = frappe.db.get_value(
		dt_from_appointment,
		filters={'appointment': appointment}
	)
	if dn_from_appointment:
		frappe.db.set_value(dt_from_appointment, dn_from_appointment, 'invoiced', invoiced)



@frappe.whitelist()
def render_docs_as_html(docs):
	# docs key value pair {doctype: docname}
	docs_html = "<div class='col-md-12 col-sm-12 text-muted'>"
	for doc in docs:
		docs_html += render_doc_as_html(doc['doctype'], doc['docname'])['html'] + '<br/>'
		return {'html': docs_html}


@frappe.whitelist()
def render_doc_as_html(doctype, docname, exclude_fields = []):
	#render document as html, three column layout will break
	doc = frappe.get_doc(doctype, docname)
	meta = frappe.get_meta(doctype)
	doc_html = "<div class='col-md-12 col-sm-12'>"
	section_html = ''
	section_label = ''
	html = ''
	sec_on = False
	col_on = 0
	has_data = False
	for df in meta.fields:
		#on section break append append previous section and html to doc html
		if df.fieldtype == "Section Break":
			if has_data and col_on and sec_on:
				doc_html += section_html + html + "</div>"
			elif has_data and not col_on and sec_on:
				doc_html += "<div class='col-md-12 col-sm-12'\
				><div class='col-md-12 col-sm-12'>" \
				+ section_html + html +"</div></div>"
			while col_on:
				doc_html += "</div>"
				col_on -= 1
			sec_on = True
			has_data= False
			col_on = 0
			section_html = ''
			html = ''
			if df.label:
				section_label = df.label
			continue
		#on column break append html to section html or doc html
		if df.fieldtype == "Column Break":
			if sec_on and has_data:
				section_html += "<div class='col-md-12 col-sm-12'\
				><div class='col-md-6 col\
				-sm-6'><b>" + section_label + "</b>" + html + "</div><div \
				class='col-md-6 col-sm-6'>"
			elif has_data:
				doc_html += "<div class='col-md-12 col-sm-12'><div class='col-m\
				d-6 col-sm-6'>" + html + "</div><div class='col-md-6 col-sm-6'>"
			elif sec_on and not col_on:
				section_html += "<div class='col-md-6 col-sm-6'>"
			html = ''
			col_on += 1
			if df.label:
				html += '<br>' + df.label
			continue
		#on table iterate in items and create table based on in_list_view, append to section html or doc html
		if df.fieldtype == 'Table':
			items = doc.get(df.fieldname)
			if not items: continue
			child_meta = frappe.get_meta(df.options)
			if not has_data : has_data = True
			table_head = ''
			table_row = ''
			create_head = True
			for item in items:
				table_row += '<tr>'
				for cdf in child_meta.fields:
					if cdf.in_list_view:
						if create_head:
							table_head += '<th>' + cdf.label + '</th>'
						if item.get(cdf.fieldname):
							table_row += '<td>' + str(item.get(cdf.fieldname)) \
							+ '</td>'
						else:
							table_row += '<td></td>'
				create_head = False
				table_row += '</tr>'
			if sec_on:
				section_html += "<table class='table table-condensed \
				bordered'>" + table_head +  table_row + '</table>'
			else:
				html += "<table class='table table-condensed table-bordered'>" \
				+ table_head +  table_row + "</table>"
			continue
		#on other field types add label and value to html
		if not df.hidden and not df.print_hide and doc.get(df.fieldname) and df.fieldname not in exclude_fields:
			html +=  '<br>{0} : {1}'.format(df.label or df.fieldname, \
			doc.get(df.fieldname))
			if not has_data : has_data = True
	if sec_on and col_on and has_data:
		doc_html += section_html + html + '</div></div>'
	elif sec_on and not col_on and has_data:
		doc_html += "<div class='col-md-12 col-sm-12'\
		><div class='col-md-12 col-sm-12'>" \
		+ section_html + html +'</div></div>'
	if doc_html:
		doc_html = "<div class='small'><div class='col-md-12 text-right'><a class='btn btn-default btn-xs' href='#Form/%s/%s'></a></div>" %(doctype, docname) + doc_html + '</div>'

	return {'html': doc_html}
