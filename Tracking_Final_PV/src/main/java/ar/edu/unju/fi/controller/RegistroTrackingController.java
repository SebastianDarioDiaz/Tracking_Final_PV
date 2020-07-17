package ar.edu.unju.fi.controller;

import java.util.List;

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
import ar.edu.unju.fi.entity.Tripulante;
import ar.edu.unju.fi.entity.Vehiculo;
import ar.edu.unju.fi.service.ILocalidadService;
import ar.edu.unju.fi.service.IRegistroTrackingService;
import ar.edu.unju.fi.service.ITripulanteService;
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
	
	@Autowired
	private ITripulanteService tripulanteService;
	
	@Autowired
	private Localidad localidad;
	
	@Autowired
	private Vehiculo vehiculo;
			///REGISTRO TRACKING///
			///REGISTRO TRACKING///
			///REGISTRO TRACKING///
			@GetMapping("/registros/listar")
			public String listarRegistros(Model model) {
				//Localidad localidadNueva = new Localidad();
				//model.addAttribute("localidad", new Localidad());
				//model.addAttribute("vehiculo", new Vehiculo());
				

				model.addAttribute("registros", registroService.listarRegistros());
				
				return "listarRegistros";
			}
			
			@GetMapping("/registros/crear")
			public String crearRegistro(Model model)  {
				RegistroTracking registroNuevo = new RegistroTracking();
				/*Localidad localidadNuevo = new Localidad();
				Vehiculo vehiculoNuevo = new Vehiculo();*/
				//Tripulante tripulanteGuardar = new Tripulante();
				//Iterable<Tripulante> tripulantes = tripulanteService.listarTripulantes();
				//Iterable<Localidad> localidades = localidadService.listarLocalidades();
				Iterable<Vehiculo> vehiculos = vehiculoService.listarVehiculos();
				model.addAttribute("registro", registroNuevo); 
				/*model.addAttribute("localidad", localidadNuevo);
				model.addAttribute("vehiculo", vehiculoNuevo);*/
				//model.addAttribute("tripulanteGuardar", tripulanteGuardar);
				//model.addAttribute("tripulantes", tripulantes);
				model.addAttribute("vehiculos", vehiculos); 
				//model.addAttribute("localidades", localidades); 
				model.addAttribute("registros", registroService.listarRegistros());
				
				System.out.println("Registro Tracking Creado");
				return "frmCrearRegistro";
			}
			
			@PostMapping("/registros/guardar")
			public String guardarRegistro(@Valid @ModelAttribute RegistroTracking registro,BindingResult result)  {
				//Iterable<Tripulante> tripulantes = tripulanteService.listarTripulantes();
				//Iterable<Localidad> localidades = localidadService.listarLocalidades();
				Iterable<Vehiculo> vehiculos = vehiculoService.listarVehiculos();
				//Tripulante tripulanteGuardar = new Tripulante();
				//registroNuevo.getTripulantes().add(tripulanteGuardar);
				
				
				
				/*if(result.hasErrors()) {
					model.addAttribute("registro", registroNuevo); 
					
					///model.addAttribute("tripulanteGuardar", tripulanteGuardar);
					
					//model.addAttribute("tripulantes", tripulantes);
					model.addAttribute("vehiculos", vehiculos); 
					//model.addAttribute("localidades", localidades); 
					System.out.println("Error al guardar Registro Tracking");
					model.addAttribute("registros", registroService.listarRegistros());
					return "frmCrearRegistro";
				}*/
				
				//model.addAttribute("tripulanteGuardar", tripulanteGuardar);
				/*Vehiculo vehiculoNuevo = new Vehiculo("PATENTE", "COLOR", "TITULAR", "MARCA", "M", "T", "C", "M");
				vehiculoService.guardarVehiculo(vehiculoNuevo);*/
				registroService.guardarRegistro(registro);	
				System.out.println("Registro Tracking Guardado");
				
				return "redirect:/registros/listar";
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