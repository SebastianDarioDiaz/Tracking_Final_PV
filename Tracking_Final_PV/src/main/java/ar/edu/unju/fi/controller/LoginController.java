/**
 * 
 */
package ar.edu.unju.fi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import ar.edu.unju.fi.entity.Usuario;
import ar.edu.unju.fi.service.IUsuarioService;

/**
 * @author Diaz, Sebastián Darío - L.U.:3283
 *
 */
@Controller
public class LoginController {

	@Autowired
	private Usuario usuario;
	
	@Autowired
	private IUsuarioService usuarioService;
	
	@GetMapping({"/","/login"})
	public String ingresar(Model model) {
		return "index";
	}
	
	@PostMapping("/ingresarUsuario")
	public String loginUsuario(@ModelAttribute("usuarioForm")Usuario usuario, ModelMap model) throws Exception {
		String redireccion="";
		/*
		try {
			Usuario usuarioBuscado = usuarioService.buscarUsuario(usuario);
			if(usuarioBuscado == null) {
				throw new Exception("Nombre de Usuario o Contraseña inválida");
		}catch (Exception e) {
			// TODO: handle exception
		}
		*/
		return "";
	}
}
