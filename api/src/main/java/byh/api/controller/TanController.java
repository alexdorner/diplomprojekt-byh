package byh.api.controller;

import javax.servlet.http.HttpSession;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import tanService.TanService;

@Controller
public class TanController {
	JSONObject jsonString = new JSONObject();
	
	@Autowired
    public TanService tanService;
	
	//http://localhost:8080/api/getTan
	@ResponseBody
	@GetMapping("/api/getTan")
	public String tan(HttpSession session) {
		
		jsonString.put("tan", tanService.getTan(session.getId()));
    		
    	return jsonString.toString();
	} 
}
