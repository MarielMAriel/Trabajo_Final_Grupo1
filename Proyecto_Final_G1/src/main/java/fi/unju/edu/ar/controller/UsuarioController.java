package fi.unju.edu.ar.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import fi.unju.edu.ar.entity.Empleado;
import fi.unju.edu.ar.service.IEmpleadoService;
@Controller
public class UsuarioController {
	@Autowired
	private IEmpleadoService empleadoService;
	private Empleado empleado =new Empleado() ;
	
	String provincias[] = {"Jujuy","Buenos Aires","Catamarca","Chaco","Chubut"
			,"Córdoba","Córdoba","Entre Ríos","Formosa","La Pampa","La Rioja","Mendoza","Misiones","Neuquén"
			,"Río Negro","Salta","San Juan","Santa Cruz","Santa Fe","Santiago del Estero","Tierra del Fuego","Tucumán"};
	

	@GetMapping("/NuevoUsu")
	public ModelAndView getFormEmpleado() {
		ModelAndView mav = new ModelAndView("nuevo_empleado");
		mav.addObject("empleado", empleado);
		return mav;
	}
	@PostMapping("/guardarEmp")
	public ModelAndView guardarEmplNuevo(@Valid Empleado empleado) {
		empleadoService.guardarEmplado(empleado);
		ModelAndView mav=new  ModelAndView("index");
		return mav;
	}
}
