package fi.unju.edu.ar.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import fi.unju.edu.ar.entity.Curso;
import fi.unju.edu.ar.entity.Empleado;
import fi.unju.edu.ar.entity.Empresa;
import fi.unju.edu.ar.entity.Institucion;
import fi.unju.edu.ar.entity.OfertaLab;
import fi.unju.edu.ar.entity.Usuario;
import fi.unju.edu.ar.service.IEmpleadoService;
import fi.unju.edu.ar.service.IEmpresaService;
import fi.unju.edu.ar.service.IOfertaService;
import fi.unju.edu.ar.service.IUsuarioService;
import fi.unju.edu.ar.service.InstitucionService;
import fi.unju.edu.ar.serviceImp.ICursoServiceImp;

@Controller
public class EmpleadoController {
	/**
	 * Carga de las provincias a seleccionar en el registro del empleado.
	 */
	String provincias[]= {"  ","Buenos Aires" ,"Ciudad Autónoma de Buenos Aires","Catamarca","Chaco","Chubut","Córdoba","Corrientes","Entre Ríos","Formosa",
			"Jujuy","La Pampa","La Rioja","Mendoza","Misiones","Neuquén","Río Negro",
			"Salta","San Juan","San Luis","Santa Cruz","Santa Fe","Santiago del Estero","Tierra del Fuego","Tucumán"};
	
	String estados[]= {" ","Soltero","Casado","Separado","Divorcio","Viudo"};
	/**
	 * se utiliza este objeto para realizar el mensaje de linea de traza
	 */
	
	private static final Log LOGGER = LogFactory.getLog(EmpleadoController.class);
	/**
	 * Inyecto de la instancia del Service en empleadoService
	 */
	@Autowired
	private IEmpleadoService empleadoService;
	/**
	 *  Inyecto de la instancia del Service en usuarioService
	 */
	@Autowired
	private IUsuarioService usuarioService;
	/**
	 *  Inyecto de la instancia del Service en ofertaService
	 */
	@Autowired
	private IOfertaService ofertaService;
	
	@Autowired
	private ICursoServiceImp cursoServiceImp;
	
	@Autowired
	private InstitucionService institucionService;

	/**
	 * creacion de un nuevo objeto
	 */
	private Empleado activoEmpleado=new Empleado();
	/**
	 * Se muestra la vista del formulario registro Empleado
	 * @return nuevo_empleado
	 */
	@GetMapping("/NuevoUsu")
	public ModelAndView getFormEmpleado() {
		LOGGER.info("se esta registrando una nueva entidad empleado");
		ModelAndView mav = new ModelAndView("nuevo_empleado");
		mav.addObject("empleado", empleadoService.getEmpleado());
		mav.addObject("provincias", provincias);
		mav.addObject("estados", estados);
		return mav;
	}
	/**
	 *  Respuesta a la carga del usuario, si este esta correcto redirecciona al menu
	 * Si este mismo no redirecciona se debe llenar nuevamente
	 * @param empleado
	 * @param bindingResult
	 * @return NuevoUsu
	 */
	@PostMapping("/guardarEmp")
	public ModelAndView guardarEmplNuevo(@Validated @ModelAttribute Empleado empleado, BindingResult bindingResult) {
		if (bindingResult.hasErrors()) {
			LOGGER.info("no se cumplen las validaciones "+empleado);
			ModelAndView mav=new ModelAndView("redirect:/NuevoUsu");
			return mav;
		}
		/**
		 * Se extrae valores del empleado registrado y estos son guardados en la objeto instanciado de tipo usuario
		 */
		Usuario usuario = usuarioService.setearUsuarioi(empleado);
		/**
		 * Se guardan Empleado y usuario son guardados en la BD
		 */
		empleadoService.guardarEmplado(empleado);
		usuarioService.crear(usuario);
		LOGGER.info("se agrego con exito un nuevo registro a la BD");
		ModelAndView mav=new  ModelAndView("redirect:/logEmpr");
		return mav;
	}
	/**
	 * esta es la respuesta del loggin, y este mismo (Authentication) recibe el usuario que esta activo
	 * @param authentication
	 * @return index_empleado
	 */
		
	@RequestMapping("/indexEmpl")
	public ModelAndView getIndezEmpleados(Authentication authentication) {
		activoEmpleado=empleadoService.buscar(authentication.getName());
		ModelAndView mav = new ModelAndView("index_empleado");
		return mav;
	}	
	

	/**
	 * Retorna una vista de tabla que permite ver todas las ofertas laborales de las  empresas
	 * @return ofertas
	 */
	@GetMapping("/ofertasLaborales")
	public ModelAndView getAllOfertas() {
		ModelAndView mav = new  ModelAndView("listaAllOfertas");
	
		mav.addObject("ofertas", ofertaService.getlistaOfertaLab());
		
		return mav;
	}
	/**
	 * Metodo para postularse a una oferta laboral, y este mismo retorna al index del empleado una vez elegida su opcion
	 * @param id
	 * @return index_empleado
	 */
	
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
	
	@GetMapping("/cursos")
	public ModelAndView getCursos(Model model){
		ModelAndView mav=new ModelAndView("cursos");
		mav.addObject("cursos", cursoServiceImp.listaCursos());
		return mav; 
	}
	
	@GetMapping("/inscripto/{id}")
	public ModelAndView getInscripcion(@PathVariable Long id) {
		//curso seleccionado por el usuario
		
		Curso cur=cursoServiceImp.buscarCurso(id);
		LOGGER.info(cur);
		cur.getInscriptos().add(activoEmpleado);
		activoEmpleado.setCurso(cur);
		Institucion institucion = cur.getInstitucion();
		institucionService.guardar(institucion);
		LOGGER.info(institucion);
		ModelAndView mav = new ModelAndView("redirect:/indexEmpl");
		return mav;
	}
	
}

