package at.byh.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import at.byh.tan.TAN;

@Controller
public class TANController {
	
	@GetMapping("/tan")
	public void tan() {
		
		TAN tan = new TAN();
		
		return;  
	} 
}
