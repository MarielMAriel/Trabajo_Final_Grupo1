package fi.unju.edu.ar.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;



@Controller
public class IndexController {
	
	
	@GetMapping("/inicio")
	public String getIndex() {
		return "index";
	}
	
	@GetMapping("/loginEmpresa")
	public ModelAndView getLoginEmpresa() {
		ModelAndView mav = new ModelAndView("login_empresa");
		return mav;
	}
	
	
	
}
