/**
 * 
 */
package ar.edu.unju.fi.service.imp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.edu.unju.fi.entity.Usuario;
import ar.edu.unju.fi.repository.IUsuarioRepository;
import ar.edu.unju.fi.service.IUsuarioService;

/**
 * @author Diaz, Sebastián Darío - L.U.:3283
 *
 */
@Service
public class UsuarioServiceImp implements IUsuarioService {

	@Autowired
	private IUsuarioRepository usuarioRepository;
	
	@Autowired
	private Usuario usuario;
	
	@Override
	public void guardarUsuario(Usuario usuario) {
		// TODO Auto-generated method stub
		usuarioRepository.save(usuario);	
	}

	@Override
	public void eliminarUsuario(Long id) {
		// TODO Auto-generated method stub
		usuarioRepository.deleteById(id);
	}

	@Override
	public Usuario modificarUsuario(Usuario usuario) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Usuario buscarUsuario(Long id) throws Exception {
		// TODO Auto-generated method stub
		return usuarioRepository.findById(id).orElseThrow( ()-> new Exception("El usuario noe xiste"));
	}

	@Override
	public Iterable<Usuario> listarUsuarios() {
		// TODO Auto-generated method stub
		return usuarioRepository.findAll();
	}



}
