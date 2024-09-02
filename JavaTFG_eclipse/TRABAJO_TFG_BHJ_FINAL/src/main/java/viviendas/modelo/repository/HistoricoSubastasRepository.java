package viviendas.modelo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import viviendas.modelo.entities.HistoricoSubastas;

@Repository
public interface HistoricoSubastasRepository extends JpaRepository<HistoricoSubastas, Integer>{

	@Query("select hs FROM HistoricoSubastas hs WHERE hs.usuario.idUsuario = ?1")
	List<HistoricoSubastas> findByUsuario(int idUsuario);
	
	@Query("select hs FROM HistoricoSubastas hs WHERE hs.vivienda.idVivienda = ?1")
	List<HistoricoSubastas> findByVivienda(int idVivienda);
}
