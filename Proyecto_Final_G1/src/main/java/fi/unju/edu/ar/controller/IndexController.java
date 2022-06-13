package fi.unju.edu.ar.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import fi.unju.edu.ar.model.Empleado;

@Controller
public class IndexController {
	Empleado empleado =new Empleado() ;
	
	@GetMapping("/inicio")
	public String getIndex() {
		
		return "index";
	}
	
	@GetMapping("/NuevoUsu")
	public ModelAndView getFormusUsuario() {
		ModelAndView mav = new ModelAndView("usuario");
		mav.addObject("usuario", empleado);
		return mav;
	}
	
	
	
}
