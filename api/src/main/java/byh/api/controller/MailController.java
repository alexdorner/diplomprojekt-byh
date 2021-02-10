package byh.api.controller;

import javax.servlet.http.HttpSession;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import mailService.MailConfig;
import mailService.MailService;
import tanService.TanService;

@Controller
public class MailController {
	JSONObject jsonString = new JSONObject();

    @Autowired
    public MailService mailService;
    @Autowired
    public MailConfig mailConfig;
    @Autowired
    public TanService tanService;
 
    //http://localhost:8080/api/sendMail?to=gru18163@spengergasse.at
    @ResponseBody
    @RequestMapping("/api/sendMail")
    public String mail(HttpSession session, @RequestParam("to") String to) {
    	
    	mailService.config(mailConfig.getMailConfig());
    	boolean ret = mailService.send(mailConfig.getMailConfig().getFrom(), to, "Angeforderte TAN-Nummer", "Ihre TAN-Nummer lautet: ", tanService.getTan(session.getId()));
    	
    	if(ret)
    		jsonString.put("returnCode", "ok");
    	else
    		jsonString.put("returnCode", "nok");
    	
    	return jsonString.toString();
    }
}
