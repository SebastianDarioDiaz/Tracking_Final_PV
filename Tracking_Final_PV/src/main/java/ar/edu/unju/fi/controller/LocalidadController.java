package ar.edu.unju.fi.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import ar.edu.unju.fi.entity.Localidad;
import ar.edu.unju.fi.service.ILocalidadService;




@Controller
@RequestMapping
public class LocalidadController {
	
	@Autowired
	ILocalidadService localidadService;
	
	@Autowired
	private Localidad localidad;
	
	///LOCALIDAD///
		///LOCALIDAD///
		///LOCALIDAD///
		@GetMapping("/localidades/listar")
		public String listarLocalidades(Model model) {
			//Localidad localidadNueva = new Localidad();
			//model.addAttribute("localidadNueva", localidadNueva);
			

			model.addAttribute("localidades", localidadService.listarLocalidades());
			
			return "listarLocalidades";
		}
		
		@GetMapping("/localidades/crear")
		public String crear(Model model) {
			Localidad localidadNueva = new Localidad();
			model.addAttribute("localidad", localidadNueva); 
			model.addAttribute("localidades", localidadService.listarLocalidades());
			return "frmCrearLocalidad";
		}
		
		@PostMapping("/localidades/save")
		public String guardarLocalidad(@Valid @ModelAttribute Localidad localidadNueva,BindingResult result,Model model) {
			if(result.hasErrors()) {
				model.addAttribute("localidad", localidad); 
				model.addAttribute("localidades", localidadService.listarLocalidades());
				System.out.println("Error al guardar Localidad");
				return "frmCrearLocalidad";
			}
			
			localidadService.guardarLocalidad(localidadNueva);
			System.out.println("Localidad Guardada");
			
			return "redirect:/localidades/listar/";
		}
		
		@GetMapping("/localidades/editar/{id}")
		public String editar(@PathVariable("id")Long idLocalidad ,Model model ) throws Exception{
			try {
				Localidad localidad = localidadService.buscarLocalidad(idLocalidad);
				//Iterable<Localidad> listaLocalidades = localidadService.listarLocalidades();
				model.addAttribute("localidad", localidad);
				//model.addAttribute("listaLocalidades", localidadService.listarLocalidades());
			}catch (Exception e) {
				// TODO: handle exception
			}

			return "frmCrearLocalidad";
		}
		
		@GetMapping("/localidades/eliminar/{id}")
		public String eliminar(@PathVariable("id")Long idLocalidad ) throws Exception{
			try {
				localidadService.eliminarLocalidad(idLocalidad);
			}catch (Exception e) {
				// TODO: handle exception
			}

			return "redirect:/localidades/listar";
		}
				///LOCALIDAD///
				///LOCALIDAD///
				///LOCALIDAD///
	
}
