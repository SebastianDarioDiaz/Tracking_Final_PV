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

import ar.edu.unju.fi.entity.Localidad;
import ar.edu.unju.fi.entity.RegistroTracking;
import ar.edu.unju.fi.entity.Vehiculo;
import ar.edu.unju.fi.service.ILocalidadService;
import ar.edu.unju.fi.service.IRegistroTrackingService;
import ar.edu.unju.fi.service.IVehiculoService;

@Controller
public class RegistroTrackingController {
	
	@Autowired 
	private RegistroTracking registroTracking;
	
	@Autowired
	private IRegistroTrackingService registroService;
	
	@Autowired
	private ILocalidadService localidadService;
	
	@Autowired
	private IVehiculoService vehiculoService;
	
			///REGISTRO TRACKING///
			///REGISTRO TRACKING///
			///REGISTRO TRACKING///
			@GetMapping("/registros/listar")
			public String listarRegistros(Model model) {
				//Localidad localidadNueva = new Localidad();
				//model.addAttribute("localidadNueva", localidadNueva);
				

				model.addAttribute("registros", registroService.listarRegistros());
				
				return "listarRegistros";
			}
			
			@GetMapping("/registros/crear")
			public String crearRegistro(Model model) {
				RegistroTracking registroNuevo = new RegistroTracking();
				Iterable<Localidad> localidades = localidadService.listarLocalidades();
				Iterable<Vehiculo> vehiculos = vehiculoService.listarVehiculos();
				model.addAttribute("registro", registroNuevo); 
				model.addAttribute("registros", registroService.listarRegistros());
				//Lista de Vehiculos para el Select.
				model.addAttribute("vehiculos", vehiculos); 
				//Lista de localidades para el select.
				model.addAttribute("localidades", localidades); 
				
				return "frmCrearRegistro";
			}
			
			@PostMapping("/registros/guardar")
			public String guardarRegistro(@Valid @ModelAttribute RegistroTracking registroNuevo,BindingResult result,Model model) {
				if(result.hasErrors()) {
					model.addAttribute("registro", registroTracking); 
					model.addAttribute("registros", registroService.listarRegistros());
					System.out.println("Error al guardar Registro Tracking");
					return "frmCrearRegistro";
				}
				
				registroService.guardarRegistro(registroNuevo);	
				System.out.println("Registro Tracking Guardada");
				
				return "redirect:/registros/listar/";
			}
			
			@GetMapping("/registros/editar/{id}")
			public String editar(@PathVariable("id")Long idRegistro ,Model model ) throws Exception{
				try {
					RegistroTracking registro = registroService.buscarRegistro(idRegistro);

					model.addAttribute("registro", registro);
					//model.addAttribute("listaLocalidades", localidadService.listarLocalidades());
				}catch (Exception e) {
					// TODO: handle exception
				}

				return "frmCrearRegistro";
			}
			
			@GetMapping("/registros/eliminar/{id}")
			public String eliminar(@PathVariable("id")Long idRegistro ) throws Exception{
				try {
					registroService.eliminarRegistro(idRegistro);
					
				}catch (Exception e) {
					// TODO: handle exception
				}

				return "redirect:/registros/listar";
			}
			///REGISTRO TRACKING///
			///REGISTRO TRACKING///
			///REGISTRO TRACKING///
	
}