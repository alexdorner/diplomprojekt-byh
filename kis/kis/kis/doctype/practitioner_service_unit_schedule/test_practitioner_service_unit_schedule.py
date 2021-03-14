import frappe
import frappe.defaults
import unittest


class Test(unittest.TestCase):
	def test(self):
		res = []
	
		try:
			frappe.set_user("Administrator")
		
			doc = frappe.get_doc({
				"doctype": "Appointment Type",
				"appointment_type": "test",
				"default_duration": "1"
			}).insert(ignore_permissions=True, ignore_mandatory=True, ignore_if_duplicate=True)	
		
			res = frappe.get_list("Appointment Type", filters=[["Appointment Type", "appointment_type", "=", "test"]], fields=["appointment_type", "default_duration"])
			
			frappe.db.rollback()
		except:
			frappe.db.rollback()
			
		self.assertEquals(len(res), 1)
		entry = [r.appointment_type for r in res]
		self.assertTrue("test" in entry)