package viviendas.modelo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import viviendas.modelo.entities.Pujas;

@Repository
public interface PujasRepository extends JpaRepository<Pujas, Integer>{

	@Query("select p FROM Pujas p WHERE p.usuario.idUsuario = ?1")
	List<Pujas> findByUsuario(int idUsuario);
	
	@Query("select p FROM Pujas p WHERE p.subasta.vivienda.idVivienda = ?1")
	List<Pujas> findByVivienda(int idVivienda);
}
