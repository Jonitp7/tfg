package viviendas.modelo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import viviendas.modelo.entities.ChatsProp;

@Repository
public interface ChatsPropRepository extends JpaRepository<ChatsProp, Integer>{

	@Query("select cp FROM ChatsProp cp WHERE cp.usuario.idUsuario = ?1")
	List<ChatsProp> findByUsuarioEmisor(int idUsuarioE);

	/*@Query("select cp FROM ChatsProp cp WHERE cp.usuario.usuarioReceptor = ?1")
	List<ChatsProp> findByUsuarioReceptor(int idUsuarioR);*/
}
