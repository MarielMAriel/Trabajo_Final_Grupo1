package fi.unju.edu.ar.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import fi.unju.edu.ar.entity.Empresa;
import fi.unju.edu.ar.service.IEmpresaService;
@Controller

public class EmpresaController {
	@Autowired//inyecto una instancia del servicio de la empresa empresaservice
	private IEmpresaService empresaService;
	
	@PostMapping("/guardarEmpresa")
	public ModelAndView altaEmpresa (@Valid Empresa empresa) {
		empresaService.guardarEmpresa(empresa);
		ModelAndView mav=new  ModelAndView("index");
		return mav;
	}
	
}
