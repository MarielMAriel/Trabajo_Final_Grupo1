package fi.unju.edu.ar.controller;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import fi.unju.edu.ar.entity.Empleado;
import fi.unju.edu.ar.entity.OfertaLab;
import fi.unju.edu.ar.entity.Usuario;
import fi.unju.edu.ar.service.IEmpleadoService;
import fi.unju.edu.ar.service.IOfertaService;
import fi.unju.edu.ar.service.IUsuarioService;

@Controller
public class EmpleadoController {
	String provincias[]= {"  ","Buenos Aires" ,"Ciudad Autónoma de Buenos Aires","Catamarca","Chaco","Chubut","Córdoba","Corrientes","Entre Ríos","Formosa",
			"Jujuy","La Pampa","La Rioja","Mendoza","Misiones","Neuquén","Río Negro",
			"Salta","San Juan","San Luis","Santa Cruz","Santa Fe","Santiago del Estero","Tierra del Fuego","Tucumán"};
	
	String estados[]= {" ","Soltero","Casado","Separado","Divorcio","Viudo"};
	
	private static final Log LOGGER = LogFactory.getLog(EmpleadoController.class);
	@Autowired
	private IEmpleadoService empleadoService;
	@Autowired
	private IUsuarioService usuarioService;
	@Autowired
	private IOfertaService ofertaService;

	
	private Empleado activoEmpleado=new Empleado();
	@GetMapping("/NuevoUsu")
	public ModelAndView getFormEmpleado() {
		LOGGER.info("se esta registrando una nueva entidad empleado");
		ModelAndView mav = new ModelAndView("nuevo_empleado");
		mav.addObject("empleado", empleadoService.getEmpleado());
		mav.addObject("provincias", provincias);
		mav.addObject("estados", estados);
		return mav;
	}
	@PostMapping("/guardarEmp")
	public ModelAndView guardarEmplNuevo(@Validated @ModelAttribute Empleado empleado, BindingResult bindingResult) {
		if (bindingResult.hasErrors()) {
			LOGGER.info("no se cumplen las validaciones "+empleado);
			ModelAndView mav=new ModelAndView("redirect:/NuevoUsu");
			return mav;
		}
		
		Usuario usuario = usuarioService.setearUsuarioi(empleado);
		empleadoService.guardarEmplado(empleado);
		usuarioService.crear(usuario);
		LOGGER.info("se agrego con exito un nuevo registro a la BD");
		ModelAndView mav=new  ModelAndView("redirect:/logEmpr");
		return mav;
	}
	/*
	//USAMOS EL guardarEmp o uno nuevo, o diferentes?
	@PostMapping("/usuario/guardado")
	public ModelAndView guardarEmplado(@ModelAttribute("usuario") Empleado usuar){
		empleadoService.guardarEmplado(usuar);
		mav.addObject("usuario", usuar);
		return mav;
	*/
	//esta es la respuesta del loggin
	
	@RequestMapping("/indexEmpl")
	public ModelAndView getIndezEmpleados(Authentication authentication) {
		activoEmpleado=empleadoService.buscar(authentication.getName());
		ModelAndView mav = new ModelAndView("index_empleado");
		return mav;
	}	
	

	
	//es la opcion que le permite ver las ofertas laborales de las  empresas
	@GetMapping("/ofertasLaborales")
	public ModelAndView getAllOfertas() {
		ModelAndView mav = new  ModelAndView("listaAllOfertas");
	
		mav.addObject("ofertas", ofertaService.getlistaOfertaLab());
		
		return mav;
	}
	
	//metodo para postularse a una oferta laboral
	@GetMapping("/postularse/{id}")
	public ModelAndView getPostularse(@PathVariable Long id) {
		List<OfertaLab>ofertas=ofertaService.getlistaOfertaLab();
		List<Empleado> empleados=new ArrayList<Empleado>();
		OfertaLab off=new OfertaLab();
		for (OfertaLab ofer : ofertas) {
			if(ofer.getId()==id) {
				empleados=ofer.getPostulados();
				off=ofer;
			}
		}
		empleados.add(activoEmpleado);
		off.setPostulados(empleados);
		ofertaService.guardar(off);
		ModelAndView mav = new ModelAndView("index_empleado");
		return mav;
	}
	
}
