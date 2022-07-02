package fi.unju.edu.ar.controller;



import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.security.core.Authentication;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

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
	/**
	 *  Carga de las provincias a seleccionar en el registro de la Empresa.
	 */
	String provincias[]= {"  ","Buenos Aires" ,"Ciudad Autónoma de Buenos Aires","Catamarca","Chaco","Chubut","Córdoba","Corrientes","Entre Ríos","Formosa",
			"Jujuy","La Pampa","La Rioja","Mendoza","Misiones","Neuquén","Río Negro",
			"Salta","San Juan","San Luis","Santa Cruz","Santa Fe","Santiago del Estero","Tierra del Fuego","Tucumán"};
	/**
	 * Inyecto una instancia del servicio de la empresa empresaservice
	 */
	@Autowired
	private IEmpresaService empresaService;
	/**
	  *  Inyecto de la instancia del Service en usuarioService
	 */
	@Autowired
	private IUsuarioService usuarioService;
	/**
	 *  Inyecto de la instancia del Service en iOfertaService
	 */
	@Autowired
	private IOfertaService iOfertaService;
	/**
	 * Inyecto de la instancia del Service en empleadoService
	 */
	@Autowired
	private IEmpleadoService empleadoService;
	/**
	 * En este atributo se guarda la empresa que esta activa en sesion
	 */
	
	private Empresa activoEmpresa=new Empresa();
	private static final Log LOGGER = LogFactory.getLog(LoginServiceImp.class);
	
	/**
	 * Se muestra la vista del formulario de registro de Empresa
	 * @return nuevo_empresa
	 */
	@GetMapping("/NuevoEmpr")
	public ModelAndView getFormEmpresa() {
		LOGGER.info("se esta registrando una nueva entidad empresa");
		ModelAndView mav =  new ModelAndView("nuevo_empresa");
		/**
		 * 
		 */
		mav.addObject("empresa", empresaService.getEmpresa());
		mav.addObject("provincias", provincias);
		return mav;
	}
	/**
	 * VERIFICAR LOGIN DE REDIRECCION A FORMULARIO DE OFERTA DE TRABAJO
	 * @param model
	 * @return ofertas
	 */
	@GetMapping("/lista_ofertas")
	public String getOfertaform(Model model) {
		model.addAttribute("ofertas", iOfertaService.getOferta());
		return "ofertas";
	}
/**
  * Respuesta a la carga de la empresa, si este esta correcto redirecciona al menu
 * Si este mismo no redirecciona se debe llenar nuevamente
 * @param empresa
 * @param bindingResult
 * @return NuevoEmpr
 */
	
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

/*
 * Respuesta del login
 */
	
	@RequestMapping("/sitioEmpresa")
	public ModelAndView getIndexEmpresa(Authentication authentication){
		
		activoEmpresa=empresaService.findByCuit(authentication.getName());
		/**
		 * El loger info se esta utilizando para coorroborar que realmente se esta sobre la empresa que se logueo
		 */

		LOGGER.info(activoEmpresa);
		ModelAndView mav = new ModelAndView("index_empresa");
		return mav;
	}
	/**
	 * Meetodo  que sirve para redirigir al formulario de carga de ofertas laborales
	 * @return formulario_Oferta
	 */
	
	@GetMapping("/nuevaOferta")
	public ModelAndView getFormOfertas() {
		ModelAndView mav = new  ModelAndView("formulario_Oferta");
		mav.addObject("ofertaLab", iOfertaService.getOferta());
		return mav;
		}
	/**
	 * Metodo para guardar el formulario de oferta cargada en la base de datos 
	 * @param ofertaLab
	 * @param bindingResult
	 * @return sitioEmpresa
	 */
	@PostMapping("/guardarOferta")
	public ModelAndView guardarOferta(@Validated @ModelAttribute OfertaLab ofertaLab,BindingResult bindingResult) {
		if(bindingResult.hasErrors()) {
			LOGGER.info("no se cumplen las validaciones "+ofertaLab);
			ModelAndView mav = new ModelAndView("redirect:/nuevaOferta");
			return mav;
		}
		/**
		 * Se agrega la oferta de trabajo previamente cargada
		 */
		ModelAndView mav = new ModelAndView("redirect:/sitioEmpresa");
		ofertaLab.setEmpresa(activoEmpresa);
		iOfertaService.guardar(ofertaLab);
		LOGGER.info("se agrego con exito una nueva oferta laboral "+ofertaLab);
		return mav;
	}
	/**
	 * 	Devuelve lista de ofertas que agrego la empresa
	 * @return lista_ofertas
	 */

	@GetMapping("/listaPropuesta")
	public ModelAndView getListaOfertas() {
		ModelAndView mav = new ModelAndView("lista_ofertas");
		
		mav.addObject("ofertas", activoEmpresa.getOfertas());
		return mav;
	}
	/**
	 * 	Es la opcion que le permite ver los perfiles de los empleados en empresa
	 * @return lista_empleado
	 */

	@GetMapping("/listaPostulantes")
	public ModelAndView getCiudadanos() {
		Buscar buscar = new Buscar();
		ModelAndView mav = new  ModelAndView("lista_empleado");
		mav.addObject("empleados", empleadoService.getListaEmpleado());
		mav.addObject("busqueda", buscar);
		return mav;
	}

	/**
	 * Metodo post mapping de respuesta a la busqueda realizada por la provincia o por la profesion
	 * @param buscar
	 * @return listaPostulantes
	 */
		@PostMapping("/listaPostulantes")
	public ModelAndView getBusqueda(@ModelAttribute Buscar buscar) {
		List<Empleado> selXProvincia= empleadoService.getListaProvincia(buscar.getValor());
		List<Empleado> selXProfecion= empleadoService.getListaProfecion(buscar.getValor());
		System.out.println(buscar.getValor());
		if(buscar.getValor().equals("")) {
			ModelAndView mav = new  ModelAndView("redirect:/listaPostulantes");
			return mav;
			/**
			 * 	Busca si existe el parametro en alguna de las tablas si pasa por la condicion if devuelve la lista correspondiente
			 */
		}else {
			if(selXProvincia.size()!=0) {
				ModelAndView mav = new  ModelAndView("lista_empleado");
				mav.addObject("empleados", selXProvincia);
				mav.addObject("busqueda", buscar);
				return mav;
			}else {
				if(selXProfecion.size()!=0) {
					ModelAndView mav = new  ModelAndView("lista_empleado");
					mav.addObject("empleados", selXProfecion);
					mav.addObject("busqueda", buscar);
					return mav;
				}
			}
			
		}
		ModelAndView mav = new  ModelAndView("redirect:/listaPostulantes");
		return mav;
	}
		/**
		 * Metodo que sirve para editar las ofertas laborales
		 * @param id
		 * @return formulario_Oferta
		 */
	
	@GetMapping("/editar/{id}")
	public ModelAndView getEditarAlumnoPage(@PathVariable Long id) {
		List<OfertaLab> ofertas = activoEmpresa.getOfertas();
		OfertaLab lab=new OfertaLab();
		for (OfertaLab ofertaLab2 : ofertas) {
			if (ofertaLab2.getId()==id) {
				lab=ofertaLab2;
			}
		}
		ModelAndView mav = new ModelAndView("formulario_Oferta");
		mav.addObject("ofertaLab",lab);
		return mav;
		
	}
	/**
	 * Este metodo nos permite eliminar una oferta de trabajo, y retorna a la lista de propuestas 
	 * @param id
	 * @return eliminar
	 */
	@GetMapping("/eliminar/{id}")
	public ModelAndView borrar(@PathVariable Long id) {
		int i=0;
		int k=0;
		List<OfertaLab> of=activoEmpresa.getOfertas();
		for (OfertaLab ofertaLab : of) {	
			if(ofertaLab.getId()==id) {
				i=k;
			}
			k++;
		}
		of.remove(i);
		iOfertaService.borrar(id);
		for (OfertaLab ofertaLab : of) {
			iOfertaService.guardar(ofertaLab);
		}
		
		activoEmpresa.setOfertas(of);
		ModelAndView mav = new ModelAndView("redirect:/listaPropuesta");
		return mav;
	}
	/**
	 * 	Metodo de vista de postulados 
	 * @param id
	 * @return postulados
	 */
	@GetMapping("/postulados/{id}")
	public ModelAndView getPostulados(@PathVariable Long id) {
		List<Empleado> postl=new ArrayList<Empleado>();
		List<OfertaLab> ofertas = activoEmpresa.getOfertas();
		for (OfertaLab ofertaLab : ofertas) {
			if(ofertaLab.getId()==id) {
				postl=ofertaLab.getPostulados();
			}
		}
		ModelAndView mav = new ModelAndView("postulados");
		mav.addObject("empleados", postl);
		return mav;
	}
	/**
	 * Solo debo cambiar el estado de la variable selec del empleado
	 * @param dni
	 * @return index_empresa
	 */

	@GetMapping("/seleccionar/{dni}")
	public ModelAndView getListSeleccionados(@PathVariable String dni) {
		Empleado empleado=empleadoService.buscar(dni);
		empleado.setSel(true);
		empleadoService.guardarEmplado(empleado);
		ModelAndView mav=new ModelAndView("index_empresa");
		return mav;
		}
		/**
		 * Se obtiene la lista de las ofertas de trabajo
		 * @return aprobados
		 */
	@GetMapping("/listaAprobados")
	public ModelAndView getAprobados() {
				List<OfertaLab> ofer=activoEmpresa.getOfertas();
		List<Empleado> emps=new ArrayList<>();
		List<Empleado> apr=new ArrayList<>();
		for (OfertaLab ofertaLab : ofer) {
			emps=ofertaLab.getPostulados();
			for (Empleado empleado : emps) {
				if(empleado.isSel()==true) {
					apr.add(empleado);
				}
			}
		}
		ModelAndView mav = new ModelAndView("aprobados");
		mav.addObject("empleados", apr);
		return mav;
	}
		
	
}
