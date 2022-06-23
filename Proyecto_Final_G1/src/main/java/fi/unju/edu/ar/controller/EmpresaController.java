package fi.unju.edu.ar.controller;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import fi.unju.edu.ar.entity.Empresa;
import fi.unju.edu.ar.entity.Usuario;
import fi.unju.edu.ar.service.IEmpresaService;
import fi.unju.edu.ar.service.IUsuarioService;
import fi.unju.edu.ar.serviceImp.loginServiceImp;
@Controller

public class EmpresaController {
	String provincias[]= {"  ","Buenos Aires" ,"Ciudad Autónoma de Buenos Aires","Catamarca","Chaco","Chubut","Córdoba","Corrientes","Entre Ríos","Formosa",
			"Jujuy","La Pampa","La Rioja","Mendoza","Misiones","Neuquén","Río Negro",
			"Salta","San Juan","San Luis","Santa Cruz","Santa Fe","Santiago del Estero","Tierra del Fuego","Tucumán"};
	@Autowired//inyecto una instancia del servicio de la empresa empresaservice
	private IEmpresaService empresaService;
	@Autowired
	private IUsuarioService usuarioService;
	
	private static final Log LOGGER = LogFactory.getLog(loginServiceImp.class);
	
	@GetMapping("/NuevoEmpr")
	public ModelAndView getFormEmpresa() {
		LOGGER.info("se esta registrando una nueva entidad empresa");
		ModelAndView mav =  new ModelAndView("nuevo_empresa");
		mav.addObject("empresa", empresaService.getEmpresa());
		mav.addObject("provincias", provincias);
		return mav;
	}
	
	@PostMapping("/guardarEmpresa")
	public ModelAndView guardarEmpresa (@Validated @ModelAttribute Empresa empresa,BindingResult bindingResult) {
		if(bindingResult.hasErrors()) {
			LOGGER.info("no se cumplen las validaciones "+empresa);
			ModelAndView mav = new ModelAndView("redirect:/NuevoEmpr");
			return mav;
		}
		Usuario usuario=usuarioService.setearUsuario(empresa);
		empresaService.crear(empresa);
		usuarioService.crear(usuario);
		ModelAndView mav=new ModelAndView("redirect:/logEmpr");
		LOGGER.info("se agrego con exito un nuevo registro a la BD");
		return mav;
	}

	@GetMapping("/logEmpr")
	public ModelAndView getLogeo() {
		ModelAndView mav = new ModelAndView("login_empresa");
		mav.addObject("login", empresaService.getEmpresa());
		LOGGER.info("se solicito la ventana para ingresar al sistema");
		return mav;
	}
	@PostMapping("/login")
	public ModelAndView getIndexEmpresa() {
		ModelAndView mav = new ModelAndView("index_empresa");
		return mav;
	}
}
