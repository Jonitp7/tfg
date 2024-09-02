package viviendas.modelo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import viviendas.modelo.entities.Chatbox;

@Repository
public interface ChatboxRepository extends JpaRepository<Chatbox, Integer>{

	@Query("select cb from Chatbox cb where cb.usuario.idUsuario= ?1")
	List<Chatbox> findByUsuario(int idUsuario);
}
