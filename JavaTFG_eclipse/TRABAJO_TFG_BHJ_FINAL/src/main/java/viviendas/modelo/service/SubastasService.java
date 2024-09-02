package viviendas.modelo.service;

import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Repository;

import viviendas.modelo.entities.Alquileres;
import viviendas.modelo.entities.Subastas;

@Repository
public interface SubastasService {

	int insertOne(Subastas subasta);
	int deleteOne(int idSubasta);
	List<Subastas> findAll();
	Subastas findById(int idSubasta);
	List<Subastas> findByUsuario(int idUsuario);
	List<Subastas> findByVivienda(int idVivienda);
}
