from __future__ import unicode_literals
from frappe import _

def get_data():
	return [
		{
			"label": _("Portal"),
			"items": [
				{
					"type": "doctype",
					"name": "Homepage",
					"description": _("Settings for website homepage"),
				},
				{
					"type": "doctype",
					"name": "Homepage Section",
					"description": _("Add cards or custom sections on homepage"),
				}
			]
		}
	]
