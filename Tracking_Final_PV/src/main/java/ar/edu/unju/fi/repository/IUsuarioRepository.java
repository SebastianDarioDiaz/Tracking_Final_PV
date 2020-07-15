/**
 * 
 */
package ar.edu.unju.fi.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import ar.edu.unju.fi.entity.Usuario;

/**
 * @author Diaz, Sebastián Darío - L.U.:3283
 *
 */
public interface IUsuarioRepository extends JpaRepository<Usuario, Long> {

	public Optional<Usuario> findByNombreUsuario(String nombreUsuario);
	public Optional<Usuario> findByIdUsuario(Long id);
}
