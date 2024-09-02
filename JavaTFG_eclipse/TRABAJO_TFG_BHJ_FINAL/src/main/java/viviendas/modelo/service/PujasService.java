package viviendas.modelo.service;

import java.util.List;

import org.springframework.stereotype.Repository;

import viviendas.modelo.entities.Alquileres;
import viviendas.modelo.entities.Pujas;

@Repository
public interface PujasService {

	int insertOne(Pujas puja);
	int deleteOne(int idPuja);
	List<Pujas> findAll();
	Pujas findById(int idPuja);
	List<Pujas> findByUsuario(int idUsuario);
	List<Pujas> findByVivienda(int idVivienda);
}
