package viviendas.modelo.service;

import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Repository;

import viviendas.modelo.entities.Subasta;
@Repository
public interface SubastaService {

	int insertOne(Subasta subasta);
	int deleteOne(int idSubasta);
	List<Subasta> findbyFechaInicio(Date fechaI);
	List<Subasta> findbyFechaFin(Date fechaF);
	List<Subasta> findAll();
	Subasta findById(int idSubasta);
	
}
