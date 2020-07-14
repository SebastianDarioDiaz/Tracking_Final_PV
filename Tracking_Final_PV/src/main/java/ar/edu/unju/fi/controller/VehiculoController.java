package ar.edu.unju.fi.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;


import ar.edu.unju.fi.entity.Vehiculo;
import ar.edu.unju.fi.service.IVehiculoService;
@Controller
public class VehiculoController {
	
	
	
	@Autowired
	IVehiculoService vehiculoService;
	
	
	@Autowired
	private Vehiculo vehiculo;
	
	///VEHICULO///
		///VEHICULO///
		///VEHICULO///
		@GetMapping("/vehiculos/listar")
		public String listarVehiculos(Model model) {

			model.addAttribute("vehiculos", vehiculoService.listarVehiculos());
			
			return "listarVehiculos";
		}
		
		@GetMapping("/vehiculos/crear")
		public String crearVehiculo(Model model) {
			Vehiculo vehiculoNuevo = new Vehiculo();
			model.addAttribute("vehiculo", vehiculoNuevo); 
			model.addAttribute("vehiculos", vehiculoService.listarVehiculos());
			return "frmCrearVehiculo";
		}
		
		@PostMapping("/vehiculos/guardar")
		public String guardarVehiculo(@ModelAttribute Vehiculo vehiculoNuevo) {
			vehiculoService.guardarVehiculo(vehiculoNuevo);
			return "redirect:/vehiculos/listar/";
		}
		
		@GetMapping("/vehiculos/editar/{id}")
		public String editarVehiculo(@PathVariable("id")Long idVehiculo ,Model model ) throws Exception{
			try {
				Vehiculo vehiculo = vehiculoService.buscarVehiculo(idVehiculo);
				model.addAttribute("vehiculo", vehiculo);

			}catch (Exception e) {
				// TODO: handle exception
			}

			return "frmCrearVehiculo";
		}
		
		@GetMapping("/vehiculos/eliminar/{id}")
		public String eliminarVehiculo(@PathVariable("id")Long idVehiculo ) throws Exception{
			try {
				vehiculoService.eliminarVehiculo(idVehiculo);
			}catch (Exception e) {
				// TODO: handle exception
			}

			return "redirect:/vehiculos/listar";
		}
				///VEHICULO///
				///VEHICULO///
				///VEHICULO///
}
