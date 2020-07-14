/**
 * 
 */
package ar.edu.unju.fi.service;

import java.util.Optional;

import ar.edu.unju.fi.entity.RegistroTracking;

/**
 * @author Diaz, Sebastián Darío - L.U.:3283
 *
 */
public interface IRegistroTrackingService {

	public void guardarRegistro(RegistroTracking registroTracking);
	public void eliminarRegistro(Long id);
	Optional<RegistroTracking> obtenerRegistro();
	public RegistroTracking buscarRegistro(Long id) throws Exception;
	public Iterable<RegistroTracking>listarRegistros();
	
}
