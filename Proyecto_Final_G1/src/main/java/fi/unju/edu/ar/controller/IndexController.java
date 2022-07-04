package fi.unju.edu.ar.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;




@Controller
public class IndexController {
	/**
	 * Inyecto de la instancia del Service en usuarioService
	 */
	@Autowired

	
	/**
	 * Devuelve el index principal
	 */
	@RequestMapping("/home")
	public String main() {
		return "index";
	}
	/**
	 * Muestra la pagina de logeo a la empresa y al usuario
	 * @param model
	 * @return login_empresa
	 */

	@GetMapping({"/","/logEmpr"})
	public String ingresar(Model model) {
		return "login_empresa";
	}
	
	
	
}

