package fi.unju.edu.ar.controller;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import fi.unju.edu.ar.entity.Cv;
import fi.unju.edu.ar.serviceImp.CvServiceImp;

@Controller
public class CvController {
	
	private static final Log LOGGER = LogFactory.getLog(CvController.class);
	
	@Autowired CvServiceImp curriculum;

	@GetMapping("/empleado")
	public String  getIndexCv()  {
		LOGGER.info("muestra index empleado");
		return "index_empleado";

	}
	
	@GetMapping("/nuevoCv")
	public ModelAndView getNuevoCv()  {
		LOGGER.info("se esta registrando una nueva entidad cv");
		ModelAndView mav = new ModelAndView("nuevo_cv");
		mav.addObject("cv", new Cv() );
		return mav;
	}
	
	@PostMapping("/empleado/registrarCV")
	public ModelAndView guardarCV(@Validated @ModelAttribute Cv cv, BindingResult bindingResult) {
		LOGGER.info(bindingResult.getAllErrors());
		if (bindingResult.hasErrors()) {
			LOGGER.info("no se cumplen las validaciones "+ cv);
			ModelAndView mav=new ModelAndView("redirect:/empleado");
			return mav;
		}
		curriculum.guardar(cv);
		LOGGER.info("se agrego con exito un nuevo Cv a la BD");
		ModelAndView mav=new  ModelAndView("redirect:/empleado");
		return mav;
	}
	
//	@GetMapping("/empleado/descargar")
//	public String getDescargar() {
//		//REDIRECCIONA AL FORMULARIO CV DE EMMANUEL
//		return "";
//	}
	
	@GetMapping("/empleado/buscar")
	public String getBuscar() {
		//REDIRECCIONA AL FORMULARIO CV DE EMMANUEL
		return "lista_ofertas";
	}
	
}