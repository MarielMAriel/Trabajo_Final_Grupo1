package fi.unju.edu.ar.controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

public class CvController {
	@GetMapping("/solicitudCv")
	public String getIndexPage(Model model) {
		//REDIRECCIONA AL FORMULARIO CV DE EMMANUEL
		return "contacto";
	}
}
