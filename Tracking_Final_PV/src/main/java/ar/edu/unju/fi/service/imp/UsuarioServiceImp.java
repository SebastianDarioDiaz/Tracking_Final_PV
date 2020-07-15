/**
 * 
 */
package ar.edu.unju.fi.service.imp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
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
		String pw = usuario.getPassword();
		BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder(4);
		usuario.setPassword(bCryptPasswordEncoder.encode(pw));
		
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
		Usuario usuarioEncontrado = usuarioRepository.findById(id).orElseThrow( ()-> new Exception("El usuario no existe") );
		if(!usuarioEncontrado.getPassword().equals(usuario.getPassword())) {
			usuarioEncontrado = null;
		}
		return usuarioEncontrado;
	}

	@Override
	public Iterable<Usuario> listarUsuarios() {
		// TODO Auto-generated method stub
		return usuarioRepository.findAll();
	}

	@Override
	public String redirigirUsuario(Usuario usuario) {
		String vistaUsuario = "";
		if(usuario.getTipoUsuario().equals("BD")) {
			vistaUsuario = "/localidades/listar";
		}else if(usuario.getTipoUsuario().equals("REGISTRADOR")){
			vistaUsuario = "/registros/listar";
		}else if(usuario.getTipoUsuario().equals("CONSULTOR")) {
			vistaUsuario = "roles/consultar";
		}
		
		return vistaUsuario;
	}

	@Override
	public Usuario validarUsuario(String nombreUsuario) throws Exception {
		Usuario usuarioValidado = usuarioRepository.findByNombreUsuario(nombreUsuario).orElseThrow( ()-> new Exception("El usuario no existe"));
		if(!usuarioValidado.getNombreUsuario().equals(usuario.getNombreUsuario())) {
			usuarioValidado = null;
		}
		
		return usuarioValidado;
	}

	@Override
	public Usuario buscarUsuarioID(Long id) throws Exception {
		// TODO Auto-generated method stub
		return usuarioRepository.findById(id).orElseThrow( ()-> new Exception("El usuario no existe") );
	}

	@Override
	public Usuario buscarUsuarioPassword(String nombreUsuario) throws Exception {
		
		return usuarioRepository.findByNombreUsuario(nombreUsuario).orElseThrow( ()-> new Exception("El usuario no existe"));
	}



}
