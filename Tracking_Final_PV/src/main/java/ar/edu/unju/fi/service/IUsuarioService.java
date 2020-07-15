/**
 * 
 */
package ar.edu.unju.fi.service;


import org.springframework.aop.ThrowsAdvice;

import ar.edu.unju.fi.entity.Usuario;
import ar.edu.unju.fi.entity.Vehiculo;

/**
 * @author Diaz, Sebastián Darío - L.U.:3283
 *
 */
public interface IUsuarioService {

	public void guardarUsuario(Usuario usuario);
	public void eliminarUsuario(Long id);
	public Usuario modificarUsuario(Usuario usuario) throws Exception;
	public Usuario buscarUsuario(Long id) throws Exception;
	public Usuario buscarUsuarioID(Long id) throws Exception; 
	public Iterable<Usuario> listarUsuarios();
	public String redirigirUsuario(Usuario usuario);
	public Usuario validarUsuario(String nombreUsuario) throws Exception;
	public Usuario buscarUsuarioPassword(String nombreUsuario) throws Exception;
}
