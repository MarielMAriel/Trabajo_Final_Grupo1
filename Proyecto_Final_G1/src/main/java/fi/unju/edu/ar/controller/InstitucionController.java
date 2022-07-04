package fi.unju.edu.ar.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import fi.unju.edu.ar.entity.Curso;
import fi.unju.edu.ar.entity.Institucion;
import fi.unju.edu.ar.entity.Usuario;
import fi.unju.edu.ar.serviceImp.ICursoServiceImp;
import fi.unju.edu.ar.serviceImp.IUsuarioServiceImp;
import fi.unju.edu.ar.serviceImp.InstitucionServiceImp;

@Controller
public class InstitucionController {
	
	@Autowired
	InstitucionServiceImp institucionServiceImp;
	
	@Autowired 
	IUsuarioServiceImp iUsuarioServiceImp;
	
	@Autowired
	ICursoServiceImp cursoServiceImp;
	
	Institucion institucion = new Institucion();
	
	@GetMapping("/nuevoInstitucion")
	public ModelAndView formInstitucion() {
		ModelAndView mav=new ModelAndView("nuevo_institucion");
		mav.addObject("institucion", institucionServiceImp.nuevoInstitucion());
		return mav;
	}
	
	
	@PostMapping("/guardarInstitucion")
	public ModelAndView guardarInstitucion(@Valid  @ModelAttribute Institucion institucion, BindingResult bindingResult) {
		if(bindingResult.hasErrors()) {
			ModelAndView mav= new ModelAndView("redirect:/nuevoInstitucion");
			return mav;
		}
		ModelAndView mav =  new ModelAndView("redirect:/logEmpr");
		Usuario usureg=iUsuarioServiceImp.setearUsuario2(institucion);
		institucionServiceImp.guardar(institucion);
		iUsuarioServiceImp.crear(usureg);
		return mav;
	}
	
	@RequestMapping("/sitioInstitucion")
	public ModelAndView getIndexInst(Authentication authentication) {
		institucion=institucionServiceImp.buscarInstitucion(authentication.getName());
		ModelAndView mav = new ModelAndView("indexInst");
		return mav;
	}
	@GetMapping("/nuevoCurso")
	public ModelAndView formCurso() {
		ModelAndView mav = new ModelAndView("nuevo_curso");
		mav.addObject("curso", cursoServiceImp.nuevoCurso());
		return mav;
	}
	
	
	@PostMapping("/guardarCurso")
	public ModelAndView guardarCurso(@ModelAttribute Curso curso) {
		
		curso.setInstitucion(institucion);
		institucion.getCursos().add(curso);
		institucionServiceImp.guardar(institucion);
		ModelAndView mav = new ModelAndView("indexInst");
		return mav;
	}
	@GetMapping("/listaInscriptos")
	public ModelAndView getListaInscriptos() {
		ModelAndView mav=new ModelAndView("inscriptos");
		
		mav.addObject("cursos", institucion.getCursos());
		return mav;
	}
}
