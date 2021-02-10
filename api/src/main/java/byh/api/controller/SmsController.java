package byh.api.controller;

import javax.servlet.http.HttpSession;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import smsService.SmsConfig;
import smsService.SmsService;
import tanService.TanService;

@Controller
public class SmsController {
	JSONObject jsonString = new JSONObject();

	@Autowired
    public SmsService smsService;
	@Autowired
    public SmsConfig smsConfig;
	@Autowired
    public TanService tanService;

	//http://localhost:8080/api/sendSms?to=4369911345176
	@ResponseBody
	@GetMapping("/api/sendSms")
	public String sms(HttpSession session, @RequestParam("to") String to) {
		
		smsService.config(smsConfig.getSmsConfig());
		boolean ret = smsService.send(smsConfig.getSmsConfig().getFrom(), "+" + to /*"4369911345176"*/, "Ihre TAN-Nummer lautet: ", tanService.getTan(session.getId()));
		
		if(ret)
    		jsonString.put("returnCode", "ok");
    	else
    		jsonString.put("returnCode", "nok");
		
    	return jsonString.toString();
	} 
}




