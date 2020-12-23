# coding=utf-8

from __future__ import unicode_literals
from frappe import _

def get_data():
	return [

		{
			"module_name": "Healthcare",
			"color": "#FF888B",
			"icon": "fa fa-heartbeat",
			"type": "module",
			"label": _("Healthcare"),
			"hidden": 1
		},
        {
			"module_name": "Patient",
			"color": "#6BE273",
			"icon": "fa fa-user",
			"doctype": "Patient",
			"type": "link",
			"link": "List/Patient",
			"label": _("Patient"),
			"hidden": 1
        },
        {
			"module_name": "Healthcare Practitioner",
			"color": "#2ecc71",
			"icon": "fa fa-user-md",
			"doctype": "Healthcare Practitioner",
			"type": "link",
			"link": "List/Healthcare Practitioner",
			"label": _("Healthcare Practitioner"),
			"hidden": 1
        },
        {
			"module_name": "Patient Appointment",
			"color": "#934F92",
			"icon": "fa fa-calendar-plus-o",
			"doctype": "Patient Appointment",
			"type": "link",
			"link": "List/Patient Appointment",
			"label": _("Patient Appointment"),
			"hidden": 1
        },
        {
			"module_name": "Patient Encounter",
			"color": "#2ecc71",
			"icon": "fa fa-stethoscope",
			"doctype": "Patient Encounter",
			"type": "link",
			"link": "List/Patient Encounter",
			"label": _("Patient Encounter"),
			"hidden": 1
        },


        {
			"module_name": "Clinical Procedure",
			"color": "#FF888B",
			"icon": "fa fa-medkit",
			"doctype": "Clinical Procedure",
			"type": "list",
			"link": "List/Clinical Procedure",
			"label": _("Clinical Procedure"),
			"hidden": 1
        },

		{
			"module_name": "Hub",
			"color": "#009248",
			"icon": "/assets/erpnext/images/hub_logo.svg",
			"type": "page",
			"link": "Hub/Item",
			"label": _("Hub")
		},
		{
			"module_name": "Data Import",
			"color": "#FFF168",
			"reverse": 1,
			"doctype": "Data Import",
			"icon": "octicon octicon-cloud-upload",
			"label": _("Data Import"),
			"link": "List/Data Import",
			"type": "list"
		}


	]
