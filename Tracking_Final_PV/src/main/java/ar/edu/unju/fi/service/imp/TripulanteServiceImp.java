/**
 * 
 */
package ar.edu.unju.fi.service.imp;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.edu.unju.fi.entity.Tripulante;
import ar.edu.unju.fi.entity.Vehiculo;
import ar.edu.unju.fi.repository.ITripulanteRepository;
import ar.edu.unju.fi.service.ITripulanteService;

/**
 * @author Diaz, Sebastián Darío - L.U.:3283
 *
 */
@Service
public class TripulanteServiceImp implements ITripulanteService {

	@Autowired
	private ITripulanteRepository tripulanteRepository;
	@Autowired
	private Tripulante tripulante;
	
	@Override
	public void guardarTripulante() {
		// TODO Auto-generated method stub
		tripulanteRepository.save(tripulante);
	}

	@Override
	public void eliminarTripulante(Long id) {
		// TODO Auto-generated method stub
		tripulanteRepository.deleteById(id);

	}

	@Override
	public Optional<Tripulante> obtenerTripulante() {
		// TODO Auto-generated method stub
		return tripulanteRepository.findById(tripulante.getIdTripulante());
	}

	@Override
	public List<Tripulante> obtenerTripulantes() {
		// TODO Auto-generated method stub
		return tripulanteRepository.findAll();
	}

	@Override
	public Iterable<Tripulante> listarTripulantes() {
		// TODO Auto-generated method stub
		return tripulanteRepository.findAll();
	}
	

	@Override
	public Tripulante modificarTripulante(Tripulante tripulante) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Tripulante buscarTripulante(Long id) throws Exception {
		// TODO Auto-generated method stub
		return tripulanteRepository.findById(id).orElseThrow( ()-> new Exception("El tripulante no existe") );
	}

	@Override
	public void guardarTripulante(Tripulante tripulante) {
		// TODO Auto-generated method stub
		tripulanteRepository.save(tripulante);
		
	}
	
	

}
