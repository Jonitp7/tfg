package viviendas.modelo.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import viviendas.modelo.entities.Subasta;
@Repository
public interface SubastaRepository extends JpaRepository<Subasta, Integer>{

	
	@Query("select s from Subasta s where s.fechaInicio = ?1")
	List<Subasta> findbyFechaInicio(Date fechaI);
	
	@Query("select s from Subasta s where s.fechaFin = ?1")
	List<Subasta> findbyFechaFin(Date fechaF);
}
