from __future__ import unicode_literals
from frappe import _

def get_data():
	return [
		{
			"label": _("Masters"),
			"items": [
				{
					"type": "doctype",
					"name": "Patient",
					"label": _("Patient"),
					"onboard": 1
				},
				{
					"type": "doctype",
					"name": "Healthcare Practitioner",
					"label": _("Healthcare Practitioner"),
					"onboard": 1
				},
				{
					"type": "doctype",
					"name": "Practitioner Schedule",
					"label": _("Practitioner Schedule"),
					"onboard": 1
				},
				{
					"type": "doctype",
					"name": "Medical Department",
					"label": _("Medical Department"),
				},
				{
					"type": "doctype",
					"name": "Healthcare Service Unit Type",
					"label": _("Healthcare Service Unit Type")
				},
				{
					"type": "doctype",
					"name": "Healthcare Service Unit",
					"label": _("Healthcare Service Unit")
				}

			]
		},
		{
			"label": _("Consultation Setup"),
			"items": [
				{
					"type": "doctype",
					"name": "Appointment Type",
					"label": _("Appointment Type"),
				},
				{
					"type": "doctype",
					"name": "Clinical Procedure Template",
					"label": _("Clinical Procedure Template")
				}
			]
		},
		{
			"label": _("Consultation"),
			"items": [
				{
					"type": "doctype",
					"name": "Patient Appointment",
					"label": _("Patient Appointment")
				},
				{
					"type": "doctype",
					"name": "Clinical Procedure",
					"label": _("Clinical Procedure")
				},
				{
					"type": "doctype",
					"name": "Patient Encounter",
					"label": _("Patient Encounter")
				},

			]
		},
		{
			"label": _("Settings"),
			"items": [
				{
					"type": "doctype",
					"name": "Healthcare Settings",
					"label": _("Healthcare Settings"),
					"onboard": 1
				}
			]
		},



		{
			"label": _("Reports"),
			"items": [
				{
					"type": "report",
					"is_query_report": True,
					"name": "Patient Appointment Analytics",
					"doctype": "Patient Appointment"
				}

			]
		}


	]
