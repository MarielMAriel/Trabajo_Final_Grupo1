package fi.unju.edu.ar.controller;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.fasterxml.jackson.annotation.JsonCreator.Mode;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import fi.unju.edu.ar.entity.Buscar;
import fi.unju.edu.ar.entity.Empleado;
import fi.unju.edu.ar.entity.Empresa;
import fi.unju.edu.ar.entity.OfertaLab;
import fi.unju.edu.ar.entity.Usuario;
import fi.unju.edu.ar.service.IEmpleadoService;
import fi.unju.edu.ar.service.IEmpresaService;
import fi.unju.edu.ar.service.IOfertaService;
import fi.unju.edu.ar.service.IUsuarioService;
import fi.unju.edu.ar.serviceImp.LoginServiceImp;
@Controller

public class EmpresaController {
	String provincias[]= {"  ","Buenos Aires" ,"Ciudad Autónoma de Buenos Aires","Catamarca","Chaco","Chubut","Córdoba","Corrientes","Entre Ríos","Formosa",
			"Jujuy","La Pampa","La Rioja","Mendoza","Misiones","Neuquén","Río Negro",
			"Salta","San Juan","San Luis","Santa Cruz","Santa Fe","Santiago del Estero","Tierra del Fuego","Tucumán"};
	@Autowired//inyecto una instancia del servicio de la empresa empresaservice
	private IEmpresaService empresaService;
	@Autowired
	private IUsuarioService usuarioService;
	@Autowired
	private IOfertaService iOfertaService;
	@Autowired
	private IEmpleadoService empleadoService;
	
	
	
	private static final Log LOGGER = LogFactory.getLog(LoginServiceImp.class);
	
	
	@GetMapping("/NuevoEmpr")
	public ModelAndView getFormEmpresa() {
		LOGGER.info("se esta registrando una nueva entidad empresa");
		ModelAndView mav =  new ModelAndView("nuevo_empresa");
		mav.addObject("empresa", empresaService.getEmpresa());
		mav.addObject("provincias", provincias);
		return mav;
	}
//	VERIFICAR LOGIN DE REDIRECCION A FORMULARIO DE OFERTA DE TRABAJO
	@GetMapping("/lista_ofertas")
	public String getOfertaform(Model model) {
		model.addAttribute("ofertas", iOfertaService.getOferta());
		return "ofertas";
	}

	//guardamos una usuario empresa
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
		ModelAndView mav=new ModelAndView("login_empresa");
		LOGGER.info("se agrego con exito un nuevo registro a la BD");
		return mav;
	}


	//respuesta del login
	@RequestMapping("/sitioEmpresa")
	public ModelAndView getIndexEmpresa(){
		
		ModelAndView mav = new ModelAndView("index_empresa");
		return mav;
	}
	
	//metodo para redirigir al formulario de carga de ofertas laborales
	@GetMapping("/nuevaOferta")
	public ModelAndView getFormOfertas() {
		ModelAndView mav = new  ModelAndView("formulario_Oferta");
		mav.addObject("ofertaLab", iOfertaService.getOferta());
		return mav;
		}
	//metodo para guardar el formulario en la base de datos 
	@PostMapping("/guardarOferta")
	public ModelAndView guardarOferta(@Validated @ModelAttribute OfertaLab ofertaLab,BindingResult bindingResult) {
		if(bindingResult.hasErrors()) {
			LOGGER.info("no se cumplen las validaciones "+ofertaLab);
			ModelAndView mav = new ModelAndView("redirect:/nuevaOferta");
			return mav;
		}
		ModelAndView mav = new ModelAndView("redirect:/sitioEmpresa");
		//trato de agregar la oferta en la lista de ofertas de la primer empresa
		//empresaService.findByCuit("2122232425").getOfertas().add(ofertaLab);
		Empresa unemp = empresaService.findByCuit("2122232425");
		ofertaLab.setEmpresa(unemp);
		iOfertaService.guardar(ofertaLab);
		LOGGER.info("se agrego con exito una nueva oferta laboral "+ofertaLab);
		return mav;
	}
	
	//devuelve lista de ofertas 
	@GetMapping("/listaPropuesta")
	public ModelAndView getListaOfertas() {
		ModelAndView mav = new ModelAndView("lista_ofertas");
		Empresa empresa=empresaService.findByCuit("2122232425");
		mav.addObject("ofertas", empresa.getOfertas());
		return mav;
	}
	//es la opcion que le permite ver los perfiles
	@GetMapping("/listaPostulantes")
	public ModelAndView getCiudadanos() {
		Buscar buscar = new Buscar();
		ModelAndView mav = new  ModelAndView("lista_empleado");
		mav.addObject("empleados", empleadoService.getListaEmpleado());
		mav.addObject("busqueda", buscar);
		return mav;
	}
	//metodo post mapping de respuesta a la busqueda echa
	@PostMapping("/listaPostulantes")
	public ModelAndView getBusqueda(@ModelAttribute Buscar buscar) {
		System.out.println(buscar.getValor());
		if(buscar.getValor().equals("")) {
			ModelAndView mav = new  ModelAndView("redirect:/listaPostulantes");
			return mav;
		}
		//buscar si existe el parametro en alguna de las tablas si pasa el if devuelvo la lista correspondiente
		
		System.out.println(buscar.getValor());
		ModelAndView mav = new  ModelAndView("lista_empleado");
		mav.addObject("empleados", empleadoService.getListaProvincia(buscar.getValor()));
		mav.addObject("busqueda", buscar);
		return mav;
	}
}
