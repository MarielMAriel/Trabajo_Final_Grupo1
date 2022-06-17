package fi.unju.edu.ar.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import fi.unju.edu.ar.entity.Empresa;
import fi.unju.edu.ar.service.IEmpresaService;
@Controller

public class EmpresaController {
	String provincias[]= {"Buenos Aires" ,"Ciudad Autónoma de Buenos Aires","Catamarca","Chaco","Chubut","Córdoba","Corrientes","Entre Ríos","Formosa",
			"Jujuy","La Pampa","La Rioja","Mendoza","Misiones","Neuquén","Río Negro",
			"Salta","San Juan","San Luis","Santa Cruz","Santa Fe","Santiago del Estero","Tierra del Fuego","Tucumán"};
	@Autowired//inyecto una instancia del servicio de la empresa empresaservice
	private IEmpresaService empresaService;
	
	
	@GetMapping("/NuevoEmpr")
	public ModelAndView getFormEmpresa() {
		ModelAndView mav =  new ModelAndView("nuevo_empresa");
		mav.addObject("empresa", empresaService.getEmpresa());
		mav.addObject("provincias", provincias);
		return mav;
	}
	
	@PostMapping("/guardarEmpresa")
	public ModelAndView guardarEmpresa (@Valid Empresa empresa) {
		empresaService.guardarEmpresa(empresa);
		ModelAndView mav=new ModelAndView("index");
		return mav;
	}

	@GetMapping("/logEmpr")
	public ModelAndView getLogeo() {
		ModelAndView mav = new ModelAndView("login_empresa");
		return mav;
	}
}
