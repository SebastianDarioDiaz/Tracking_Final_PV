/**
 * 
 */
package ar.edu.unju.fi.service.imp;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.edu.unju.fi.entity.Localidad;
import ar.edu.unju.fi.repository.ILocalidadRepository;
import ar.edu.unju.fi.service.ILocalidadService;

/**
 * @author Diaz, Sebastián Darío - L.U.:3283
 *
 */
@Service
public class LocalidadServiceImp implements ILocalidadService {

	@Autowired
	private ILocalidadRepository localidadRepository;
	@Autowired
	private Localidad localidad;
	
	@Override
	public void guardarLocalidad(Localidad localidad) {
		// TODO Auto-generated method stub
		localidadRepository.save(localidad);
	}

	@Override
	public void eliminarLocalidad(Long id) {
		// TODO Auto-generated method stub
		localidadRepository.deleteById(id);
	}

	@Override
	public Optional<Localidad> obtenerLocalidad() {
		// TODO Auto-generated method stub
		return localidadRepository.findById(localidad.getId());
	}

	@Override
	public List<Localidad> obtenerLocalidades() {
		// TODO Auto-generated method stub
		return localidadRepository.findAll();
	}

	@Override
	public Localidad modificarLocalidad(Localidad localidad) throws Exception {
		// TODO Auto-generated method stub
		Localidad localidadGuardar = buscarLocalidad(localidad.getId());
		mapearLocalidad(localidad, localidadGuardar);
		return localidadRepository.save(localidadGuardar);
	}

	@Override
	public Localidad buscarLocalidad(Long id) throws Exception {
		// TODO Auto-generated method stub
		
		return localidadRepository.findById(id).orElseThrow( ()-> new Exception("La localidad no existe") );
	}

	@Override
	public Iterable<Localidad> listarLocalidades() {
		// TODO Auto-generated method stub
		return localidadRepository.findAll();
	}
	
	public void mapearLocalidad(Localidad localidadAmodificar, Localidad localidadModificada) {
		localidadModificada.setNombreLocalidad(localidadAmodificar.getNombreLocalidad());
	}

}
