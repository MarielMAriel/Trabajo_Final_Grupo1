package fi.unju.edu.ar.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import fi.unju.edu.ar.entity.Empleado;

@Controller
public class IndexController {
	
	
	@GetMapping("/inicio")
	public String getIndex() {
		
		return "index";
	}
	
	
	
}
