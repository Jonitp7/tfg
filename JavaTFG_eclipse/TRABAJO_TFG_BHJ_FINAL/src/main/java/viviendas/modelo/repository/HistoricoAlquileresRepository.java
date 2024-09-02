package viviendas.modelo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import viviendas.modelo.entities.HistoricoAlquileres;

@Repository
public interface HistoricoAlquileresRepository extends JpaRepository<HistoricoAlquileres, Integer>{

	@Query("select ha FROM HistoricoAlquileres ha WHERE ha.usuario.idUsuario = ?1")
	List<HistoricoAlquileres> findByUsuario(int idUsuario);
	
	@Query("select ha FROM HistoricoAlquileres ha WHERE ha.vivienda.idVivienda = ?1")
	List<HistoricoAlquileres> findByVivienda(int idVivienda);
}
