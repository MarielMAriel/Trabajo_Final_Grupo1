package fi.unju.edu.ar.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

//import fi.edu.unju.fi.model.Usuario;
import fi.unju.edu.ar.entity.Empleado;
import fi.unju.edu.ar.entity.Usuario;
import fi.unju.edu.ar.service.IEmpleadoService;
import fi.unju.edu.ar.service.IUsuarioService;
@Controller
public class UsuarioController {
	@Autowired
	private IEmpleadoService empleadoService;
	@Autowired
	private IUsuarioService usuarioService;
	

	@GetMapping("/NuevoUsu")
	public ModelAndView getFormEmpleado() {
		ModelAndView mav = new ModelAndView("nuevo_empleado");
		mav.addObject("empleado", empleadoService.getEmpleado());
		return mav;
	}
	@PostMapping("/guardarEmp")
	public ModelAndView guardarEmplNuevo(@Valid Empleado empleado) {
		Usuario usuario = usuarioService.setearUsuarioi(empleado);
		empleadoService.guardarEmplado(empleado);
		usuarioService.crear(usuario);
		ModelAndView mav=new  ModelAndView("index");
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
	@GetMapping("/listEmpl")
	public ModelAndView getListaEmpleados() {
		ModelAndView mav = new ModelAndView("lista_empleado");
		mav.addObject("empleados", empleadoService.getListaEmpleado());
		return mav;
	}
	
	
	
}
