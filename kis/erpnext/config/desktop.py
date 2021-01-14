# coding=utf-8

from __future__ import unicode_literals
from frappe import _

def get_data():
	return [
		# Modules
		{
			"module_name": "Getting Started",
			"category": "Modules",
			"label": _("Getting Started"),
			"color": "#1abc9c",
			"icon": "fa fa-check-square-o",
			"type": "module",
			"disable_after_onboard": 1,
			"description": "Dive into the basics for your organisation's needs.",
			"onboard_present": 1
		},


		# Category: "Domains"


		{
			"module_name": "KIS",
			"category": "Domains",
			"label": _("KIS"),
			"color": "#FF888B",
			"icon": "fa fa-heartbeat",
			"type": "module",
			"description": "Patient appointments, procedures and tests."
		}


	]
