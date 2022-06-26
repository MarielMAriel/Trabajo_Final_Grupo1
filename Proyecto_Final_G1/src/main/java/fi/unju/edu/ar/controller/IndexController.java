package fi.unju.edu.ar.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;



import fi.unju.edu.ar.serviceImp.loginServiceImp;



@Controller
public class IndexController {
	@Autowired
	private loginServiceImp usuarioService;
	
	
	@GetMapping("/inicio")
	public String getIndex() {
		return "index";
	}
	

	@GetMapping("/logEmpr")
	public String getLogeo(Model model) {
		
		return "login_empresa";
	}
	
	
	
}
