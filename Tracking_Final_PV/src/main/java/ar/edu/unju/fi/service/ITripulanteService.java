/**
 * 
 */
package ar.edu.unju.fi.service;

import java.util.List;
import java.util.Optional;

import ar.edu.unju.fi.entity.Tripulante;
import ar.edu.unju.fi.entity.Vehiculo;


/**
 * @author Diaz, Sebastián Darío - L.U.:3283
 *
 */
public interface ITripulanteService {

	void guardarTripulante(Tripulante tripulante);
	Optional<Tripulante> obtenerTripulante();
	List<Tripulante> obtenerTripulantes();
	public Iterable<Tripulante> listarTripulantes();
	public Tripulante modificarTripulante( Tripulante tripulante) throws Exception;
	public Tripulante buscarTripulante(Long id) throws Exception;
	void eliminarTripulante(Long id);
	void guardarTripulante();
}
