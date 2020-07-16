/**
 * 
 */
package ar.edu.unju.fi.controller;



import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author Diaz, Sebastián Darío - L.U.:3283
 *
 */
@Controller
public class MainController {

	@RequestMapping("/home")
	public String main(Model model) {
		
		return "login";
	}
	
	@GetMapping("/index")
	public String cargarPrincipal() {
		return "indexBD";
	}
	
	@GetMapping("/localidades")
	public String cargarLocalidades() {
		return "localidades";
	}
	
	@GetMapping("/registros")
	public String cargarRegistros() {
		return "registros";
	}
	
	@GetMapping("/consultas")
	public String cargarConsultas() {
		return "consultas";
	}
	
	@GetMapping({"/home","/","/login"})
	public String ingresar(Model model) {
		return "login";
	}
	
}
