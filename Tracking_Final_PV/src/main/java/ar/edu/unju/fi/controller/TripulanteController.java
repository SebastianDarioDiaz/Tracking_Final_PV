package ar.edu.unju.fi.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import ar.edu.unju.fi.entity.Tripulante;
import ar.edu.unju.fi.service.ITripulanteService;

public class TripulanteController {
	
	
	@Autowired
	ITripulanteService tripulanteService;
	
	
	@Autowired
	private Tripulante tripulante;
	
	@GetMapping("/tripulantes/listar")
	public String listarTripulantes(Model model) {

		model.addAttribute("tripulantes", tripulanteService.listarTripulantes());
		
		return "listarTripulante";
	}
	
	@GetMapping("/tripulantes/crear")
	public String crearTripulante(Model model) {
		Tripulante tripulanteNuevo = new Tripulante();
		model.addAttribute("tripulante", tripulanteNuevo); 
		model.addAttribute("tripulantes", tripulanteService.listarTripulantes());
		return "frmCrearTripulante";
	}
	
	@PostMapping("/tripulantes/guardar")
	public String guardarTripulante(@ModelAttribute Tripulante tripulanteNuevo) {
		tripulanteService.guardarTripulante(tripulanteNuevo);
		return "redirect:/tripulantes/listar/";
	}
	
	@GetMapping("/tripulantes/editar/{id}")
	public String editarTripulante(@PathVariable("id")Long idTripulante ,Model model ) throws Exception{
		try {
			Tripulante tripulante = tripulanteService.buscarTripulante(idTripulante);
			model.addAttribute("tripulante", tripulante);

		}catch (Exception e) {
			// TODO: handle exception
		}

		return "frmCrearTripulante";
	}
	
	@GetMapping("/tripulantes/eliminar/{id}")
	public String eliminarTripulante(@PathVariable("id")Long idTripulante ) throws Exception{
		try {
			tripulanteService.eliminarTripulante(idTripulante);
		}catch (Exception e) {
			// TODO: handle exception
		}

		return "redirect:/tripulantes/listar";
	}
			

}
