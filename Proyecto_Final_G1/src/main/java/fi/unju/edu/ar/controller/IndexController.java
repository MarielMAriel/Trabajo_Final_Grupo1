package fi.unju.edu.ar.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import fi.unju.edu.ar.serviceImp.LoginServiceImp;
import fi.unju.edu.ar.serviceImp.IUsuarioServiceImp;



@Controller
public class IndexController {
	@Autowired
	private IUsuarioServiceImp usuarioService;
	
	
	@RequestMapping("/home")
	public String main(Model model) {
		return "index";
	}
	

	@GetMapping({"/","/logEmpr"})
	public String ingresar(Model model) {
		return "login_empresa";
	}
	
	
	
}
