package fi.unju.edu.ar.controller;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import fi.unju.edu.ar.entity.Cv;
import fi.unju.edu.ar.entity.Empleado;
import fi.unju.edu.ar.service.IEmpleadoService;
import fi.unju.edu.ar.serviceImp.CvServiceImp;

@Controller
public class CvController {
	
	private static final Log LOGGER = LogFactory.getLog(CvController.class);
	/**
	 * Controller del Curriculum Vitae, redirecciona al index del empleado
	 */
	
	@Autowired 
	CvServiceImp curriculum;
	@Autowired 
	IEmpleadoService empleadoService;
/**
 * Muestra el index del empleado	
 * @return index_empleado
 */
	@GetMapping("/empleado")
	public String  getIndexCv()  {
		LOGGER.info("muestra index empleado");
		return "index_empleado";

	}
	/**
	 * Se muestra la vista del formulario de CV
	 * @return nuevo_cv
	 */
	
	@GetMapping("/nuevoCv")
	public ModelAndView getNuevoCv()  {
		LOGGER.info("se esta registrando una nueva entidad cv");
		ModelAndView mav = new ModelAndView("nuevo_cv");
		mav.addObject("cv", new Cv() );
		return mav;
	}
	/**
	 * Respuesta a la carga del cv, si este esta correcto redirecciona al menu
	 * Si este mismo no redirecciona se debe llenar nuevamente
	 * @param cv
	 * @param bindingResult
	 * @return empleado 
	 */
	@PostMapping("/empleado/registrarCV")
	public ModelAndView guardarCV(@Validated @ModelAttribute Cv cv, BindingResult bindingResult,Authentication authentication) {
		LOGGER.info(bindingResult.getAllErrors());
		if (bindingResult.hasErrors()) {
			LOGGER.info("no se cumplen las validaciones "+ cv);
			ModelAndView mav=new ModelAndView("redirect:/empleado");
			return mav;
		}
		Empleado act=empleadoService.buscar(authentication.getName());
		curriculum.guardar(cv);
		act.setCv(cv);
		empleadoService.guardarEmplado(act);
		LOGGER.info("se agrego con exito un nuevo Cv a la BD");
		ModelAndView mav=new  ModelAndView("redirect:/empleado");
		return mav;
	}

	/**
	 * Busqueda de lista de ofertas de trabajo en el menu de empleados 
	 * @return lista_ofertas
	 */
	
	@GetMapping("/empleado/buscar")
	public String getBuscar() {
		//REDIRECCIONA AL FORMULARIO CV DE EMMANUEL
		return "lista_ofertas";
	}
	
}
