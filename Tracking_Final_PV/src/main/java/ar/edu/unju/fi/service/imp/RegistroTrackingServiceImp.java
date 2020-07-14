/**
 * 
 */
package ar.edu.unju.fi.service.imp;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.edu.unju.fi.entity.RegistroTracking;
import ar.edu.unju.fi.repository.IRegistroTrackingRepository;
import ar.edu.unju.fi.service.IRegistroTrackingService;

/**
 * @author Diaz, Sebastián Darío - L.U.:3283
 *
 */
@Service
public class RegistroTrackingServiceImp implements IRegistroTrackingService {

	@Autowired
	private IRegistroTrackingRepository registroTrackingRepository;
	@Autowired
	private RegistroTracking registroTracking;
	
	@Override
	public void guardarRegistro(RegistroTracking registroTracking) {
		// TODO Auto-generated method stub
		registroTrackingRepository.save(registroTracking);
	}
	
	@Override
	public void eliminarRegistro(Long id) {
		// TODO Auto-generated method stub
		registroTrackingRepository.deleteById(id);
	}
	@Override
	public Optional<RegistroTracking> obtenerRegistro() {
		// TODO Auto-generated method stub
		return registroTrackingRepository.findById(registroTracking.getId());
	}
	@Override
	public RegistroTracking buscarRegistro(Long id) throws Exception {
		// TODO Auto-generated method stub
		return registroTrackingRepository.findById(id).orElseThrow( ()-> new Exception("El Registro no existe"));
	}
	@Override
	public Iterable<RegistroTracking> listarRegistros() {
		// TODO Auto-generated method stub
		return registroTrackingRepository.findAll();
	}
	

	
	
}
