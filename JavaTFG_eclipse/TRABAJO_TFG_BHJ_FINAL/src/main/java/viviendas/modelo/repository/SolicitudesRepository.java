package viviendas.modelo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import viviendas.modelo.entities.Solicitudes;



@Repository
public interface SolicitudesRepository extends JpaRepository<Solicitudes, Integer>{

	@Query("select s from Solicitudes s where s.usuario.idUsuario = ?1")
	List<Solicitudes> findByIdUsuario(int idUsuario);
}
