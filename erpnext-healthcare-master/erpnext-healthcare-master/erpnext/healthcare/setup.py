from __future__ import unicode_literals
import frappe

from frappe import _
from erpnext.setup.utils import insert_record

def setup_healthcare():
	if frappe.db.exists('Medical Department', 'Cardiology'):
		# already setup
		return
	create_medical_departments()

	create_healthcare_item_groups()
	add_healthcare_service_unit_tree_root()

def create_medical_departments():
	departments = [
		"Cardiology", "Dermatology",
		"Gastroenterology", "General Surgery", "Gynaecology",
		"Haematology", "Maternity", "Microbiology", "Nephrology", "Neurology", "Oncology",
		"Orthopaedics", "Pathology", "Physiotherapy", "Rheumatology", "Serology", "Urology"
	]
	for department in departments:
		medical_department = frappe.new_doc("Medical Department")
		medical_department.department = _(department)
		try:
			medical_department.save()
		except frappe.DuplicateEntryError:
			pass




def create_healthcare_item_groups():
	records = [
		{'doctype': 'Item Group', 'item_group_name': _('Laboratory'),
			'is_group': 0, 'parent_item_group': _('All Item Groups') },
		{'doctype': 'Item Group', 'item_group_name': _('Drug'),
			'is_group': 0, 'parent_item_group': _('All Item Groups') }
	]
	insert_record(records)



def add_healthcare_service_unit_tree_root():
	record = [
	 {
	  "doctype": "Healthcare Service Unit",
	  "healthcare_service_unit_name": "All Healthcare Service Units",
	  "is_group": 1
	 }
	]
	insert_record(record)
