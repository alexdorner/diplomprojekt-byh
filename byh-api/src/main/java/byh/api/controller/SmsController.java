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
	
	//http://localhost:8080/api/sendSummarySms?to=4369911345176&tc=15&kh=AKH&str=Gürtel 5&ort=1090 Wien&termin=07.10.2020 12:30&fb=Orthopädie, Mittelfuß&ebene=7D&tel=+4369911345176
	@ResponseBody
	@GetMapping("/api/sendSummarySms")
	public String summerySms(HttpSession session, @RequestParam("to") String to,  @RequestParam("tc") String tc, 
			@RequestParam("kh") String kh, @RequestParam("str") String str, @RequestParam("ort") String ort,
			@RequestParam("termin") String termin, @RequestParam("fb") String fb, @RequestParam("ebene") String ebene,
			@RequestParam("tel") String tel) {
		
		String summary = "";
		
		summary += "\n";
		summary += "Termincode: " + tc + "\n";
		summary += kh + "\n";
		summary += str + "\n";
		summary += ort + "\n";
		summary += "Termin: " + termin + "\n";
		summary += "Fachbereich : " + fb + "\n";
		summary += "Ebene: " + ebene + "\n";
		summary += "Telefon: " + tel + "\n";
			
		smsService.config(smsConfig.getSmsConfig());
		boolean ret = smsService.send(smsConfig.getSmsConfig().getFrom(), "+" + to /*"4369911345176"*/, summary);
			
		if(ret)
	    	jsonString.put("returnCode", "ok");
	    else
	    	jsonString.put("returnCode", "nok");
	    	
	    return jsonString.toString();
	} 
}




