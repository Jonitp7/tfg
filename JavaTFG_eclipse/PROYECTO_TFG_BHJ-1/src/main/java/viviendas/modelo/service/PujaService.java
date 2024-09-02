package viviendas.modelo.service;

import java.util.List;

import org.springframework.stereotype.Repository;

import viviendas.modelo.entities.Puja;
@Repository
public interface PujaService {

	int insertOne(Puja puja);
	int deleteOne(int idPuja);
	List<Puja> findAll();
	List<Puja> findByComprador(int idPostor);
	List<Puja> findBySubasta(int idSubasta);
	Puja findById(int idPuja);
}
