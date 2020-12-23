package at.byh.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import at.byh.sms.SmsSender;
import at.byh.tan.TAN;

@Controller
public class SMSController {

	@GetMapping("/sms")
	public String sms() {
		
		SmsSender smsSender = new SmsSender();
		smsSender.senden("Ihre TAN-Nummer lautet: " + TAN.getTan(), "+4369911345176");
		
		return "sms"; 
	} 
}




