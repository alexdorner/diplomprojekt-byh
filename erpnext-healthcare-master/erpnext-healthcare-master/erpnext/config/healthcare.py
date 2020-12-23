from __future__ import unicode_literals
from frappe import _

def get_data():

	return [
		{
			"label": _("Consultation"),
			"icon": "icon-star",
			"items": [
				{
					"type": "doctype",
					"name": "Patient Appointment",
					"label": _("Patient Appointment"),
				},

				{
					"type": "page",
					"name": "patient_history",
					"label": _("Patient History"),
				},
				{
					"type": "page",
					"name": "appointment-analytic",
					"label": _("Appointment Analytics"),
				},
				{
					"type": "doctype",
					"name": "Clinical Procedure",
					"label": _("Clinical Procedure"),
				},

				{
					"type": "doctype",
					"name": "Practitioner Event",
					"label": _("Practitioner Event")
				},

			]
		},


		{
			"label": _("Masters"),
			"icon": "icon-list",
			"items": [
				{
					"type": "doctype",
					"name": "Patient",
					"label": _("Patient"),
				},
				{
					"type": "doctype",
					"name": "Healthcare Practitioner",
					"label": _("Healthcare Practitioner"),
				},
				{
					"type": "doctype",
					"name": "Practitioner Schedule",
					"label": _("Practitioner Schedule"),
				},
				{
					"type": "doctype",
					"name": "Medical Code Standard",
					"label": _("Medical Code Standard"),
				},
				{
					"type": "doctype",
					"name": "Medical Code",
					"label": _("Medical Code"),
				},
				{
					"type": "doctype",
					"name": "Healthcare Service Unit",
					"label": _("Healthcare Service Unit")
				}
			]
		},
		{
			"label": _("Setup"),
			"icon": "icon-cog",
			"items": [
				{
					"type": "doctype",
					"name": "Healthcare Settings",
					"label": _("Healthcare Settings"),
				},
				{
					"type": "doctype",
					"name": "Medical Department",
					"label": _("Medical Department"),
				},
				{
					"type": "doctype",
					"name": "Appointment Type",
					"label": _("Appointment Type"),
				},

				{
					"type": "doctype",
					"name": "Complaint",
					"label": _("Complaint")
				},
				{
					"type": "doctype",
					"name": "Diagnosis",
					"label": _("Diagnosis")
				},
				{
					"type": "doctype",
					"name": "Clinical Procedure Template",
					"label": _("Clinical Procedure Template"),
				},
				{
					"type": "doctype",
					"name": "Healthcare Service Unit Type",
					"label": _("Healthcare Service Unit Type")
				},
				{
					"type": "doctype",
					"name": "Clinical Procedure Check List Template",
					"label": _("Clinical Procedure Check List Template"),
				}
			]
		}
	]
