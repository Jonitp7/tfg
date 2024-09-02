package viviendas.modelo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import viviendas.modelo.entities.Chatbox;
import viviendas.modelo.entities.Roles;

@Repository
public interface RolesRepository extends JpaRepository<Roles, Integer>{

	@Query("select r FROM Roles r WHERE r.usuario.idUsuario = ?1")
	List<Roles> findByUsuario(int idUsuario);
}
