package viviendas.modelo.service;

import java.util.List;

import org.springframework.stereotype.Repository;

import viviendas.modelo.entities.Alquileres;
@Repository
public interface AlquilerService {

	int insertOne(Alquileres alquileres);
	int deleteOne(int idAlquiler);
	Alquileres findById(int idAlquiler);
	List<Alquileres> findAll();
	List<Alquileres> findByUsuario(int idUsuario);
	List<Alquileres> findByVivienda(int idVivienda);
}
