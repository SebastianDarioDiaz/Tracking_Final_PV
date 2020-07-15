package ar.edu.unju.fi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import ar.edu.unju.fi.entity.Usuario;
import ar.edu.unju.fi.service.IUsuarioService;


@Controller
public class UsuarioController {
	
	@Autowired
	private IUsuarioService usuarioService;
	
	@Autowired
	private Usuario usuario;
	
			///USUARIO///
			///USUARIO///
			///USUARIO///
	
			@GetMapping("/usuarios/listar")
			public String listarUsuarios(Model model) {
				
				/*Rol rolBD = new Rol("BD","Puede realizar ABM de Usuarios y Localidades");
				Rol rolRegistrador = new Rol("REGISTRADOR","Puede realizar registros completos de trackig");
				Rol rolConsultor = new Rol("CONSULTOR","Puede realizar consultas basadas en Localidad, Tripulante y Patente");
				if(rolService.obtenerRoles().isEmpty()) {
					rolService.guardarRol(rolBD);
					rolService.guardarRol(rolRegistrador);
					rolService.guardarRol(rolConsultor);
					model.addAttribute("usuarios", usuarioService.listarUsuarios());
				}*/
				model.addAttribute("usuarios", usuarioService.listarUsuarios());
				
				return "listarUsuarios";
			}
			
			@GetMapping("/usuarios/crear")
			public String crearUsuario(Model model) {
				Usuario usuarioNuevo = new Usuario();
				model.addAttribute("usuario", usuarioNuevo); 
				model.addAttribute("usuarios", usuarioService.listarUsuarios());
				
				return "frmCrearUsuario";
			}
			
			@PostMapping("/usuarios/guardar")
			public String guardarUsuario(@ModelAttribute Usuario usuarioNuevo) {
				usuarioService.guardarUsuario(usuarioNuevo);
				
				return "redirect:/usuarios/listar/";
			}
			
			@GetMapping("/usuarios/editar/{id}")
			public String editarUsuario(@PathVariable("id")Long idUsuario ,Model model ) throws Exception{
				try {
					Usuario usuario = usuarioService.buscarUsuario(idUsuario);
					model.addAttribute("usuario", usuario);

				}catch (Exception e) {
					// TODO: handle exception
				}

				return "frmCrearUsuario";
			}
			
			@GetMapping("/usuarios/eliminar/{id}")
			public String eliminarUsuario(@PathVariable("id")Long idUsuario ) throws Exception{
				try {
					usuarioService.eliminarUsuario(idUsuario);
				}catch (Exception e) {
					// TODO: handle exception
				}

				return "redirect:/usuarios/listar";
			}
					///VEHICULO///
					///VEHICULO///
					///VEHICULO///

}
