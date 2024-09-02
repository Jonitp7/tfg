package viviendas.modelo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import viviendas.modelo.entities.Puja;
@Repository
public interface PujaRepository extends JpaRepository<Puja, Integer>{

	@Query("select p from Puja p where p.comprador.idComprador = ?1")
	List<Puja> findByComprador(int idPostor);
	
	@Query("select p from Puja p where p.subasta.idSubasta = ?1")
	List<Puja> findBySubasta(int idSubasta);
}
