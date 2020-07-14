/**
 * 
 */
package ar.edu.unju.fi.service;


import ar.edu.unju.fi.entity.Usuario;

/**
 * @author Diaz, Sebastián Darío - L.U.:3283
 *
 */
public interface IUsuarioService {

	public void guardarUsuario(Usuario usuario);
	public void eliminarUsuario(Long id);
	public Usuario modificarUsuario(Usuario usuario) throws Exception;
	public Usuario buscarUsuario(Long id) throws Exception;
	public Iterable<Usuario> listarUsuarios();
	
}
