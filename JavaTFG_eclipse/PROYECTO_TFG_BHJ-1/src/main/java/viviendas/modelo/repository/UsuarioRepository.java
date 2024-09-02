package viviendas.modelo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import viviendas.modelo.entities.Usuario;
@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, String>{

	@Query("select u from Usuario u where u.username = ?1 and u.contraseña = ?2")
	Usuario findByUsernameAndPassword(String username, String password);
}
