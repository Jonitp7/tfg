package viviendas.modelo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import viviendas.modelo.entities.Chatbox;
import viviendas.modelo.entities.Usuarios;

@Repository
public interface UsuariosRepository extends JpaRepository<Usuarios, Integer>{

	@Query("select u from Usuarios u where u.username = ?1 and u.password = ?2")
	Usuarios findByUsernameAndPassword(String username, String password);
}
