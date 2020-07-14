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
		
		return "index";
	}
	
	@GetMapping({"/","/login"})
	public String ingresar(Model model) {
		return "index";
	}

	/*
	 * 
	 * //VEHICULO
	 * 
	 * //Método listado y filtrado de Vehículos.
	 * 
	 * @GetMapping("/vehiculos") public String cargarFormVehiculos(Model model) {
	 * model.addAttribute("vehiculos", vehiculoService.listarVehiculos());
	 * model.addAttribute("formTab","active"); return "formListadoVehiculos"; }
	 * 
	 * //Método filtrar aún no probado public LocalDateTime fechaInicio; public
	 * LocalDateTime fechaFinal; private List<RegistroTracking> filtrarVehiculos(){
	 * List<RegistroTracking> registros = (List<RegistroTracking>)
	 * registroTrackingService.listarRegistros(); List<RegistroTracking> listaNueva
	 * = new ArrayList<>(); if(fechaInicio != null && fechaFinal != null) {
	 * for(RegistroTracking r: registros) { if(r.getFechaHora().isBefore(fechaFinal)
	 * && r.getFechaHora().isAfter(fechaInicio)) { listaNueva.add(r); } } }
	 * 
	 * return listaNueva; }
	 * 
	 * @PostMapping("/vehiculos") public String filtrarVehiculos(@ModelAttribute
	 * ("nuevoVehiculo") Vehiculo vehiculo,Model model) {
	 * vehiculoService.guardarVehiculo(vehiculo);;
	 * 
	 * 
	 * model.addAttribute("nuevoVehiculo", new Vehiculo());
	 * model.addAttribute("vehiculos", vehiculoService.listarVehiculos()); //Método
	 * filtrar aún no probado model.addAttribute("listaNueva", filtrarVehiculos());
	 * model.addAttribute("listTab","active"); return "formListadoVehiculos"; }
	 * 
	 * ///TRACKING D/// //TRACKING
	 * 
	 * @GetMapping("/tracking") public String agregarRegistroTracking(Model model) {
	 * model.addAttribute("nuevoRegistroT", new RegistroTracking());
	 * model.addAttribute("nuevoVehiculo", new Vehiculo());
	 * model.addAttribute("registros", registroTrackingService.listarRegistros());
	 * model.addAttribute("formTab","active"); return "formTracking"; }
	 * 
	 * @PostMapping("/tracking") public String listarRegistros(@ModelAttribute
	 * ("nuevoRegistroT") RegistroTracking registroTracking, @ModelAttribute
	 * ("nuevoVehiculo") Vehiculo vehiculo,Model model) {
	 * registroTrackingService.guardarRegistroTracking(registroTracking);
	 * model.addAttribute("nuevoRegistroT", new RegistroTracking());
	 * vehiculoService.guardarVehiculo(vehiculo);
	 * model.addAttribute("nuevoVehiculo", new Vehiculo());
	 * 
	 * 
	 * model.addAttribute("registros", registroTrackingService.listarRegistros());
	 * model.addAttribute("listTab","active"); return "formTracking"; }
	 * 
	 * //Método listado y filtrado de Tripulantes.
	 * 
	 * @GetMapping("/tripulantes") public String cargarFormTripulantes(Model model)
	 * { model.addAttribute("tripulantes", tripulanteService.listarTripulantes());
	 * model.addAttribute("formTab","active"); return "formListadoTripulantes"; }
	 */
	
}
