package viviendas.modelo.service;

import java.util.List;

import org.springframework.stereotype.Repository;

import viviendas.modelo.entities.Alquiler;
@Repository
public interface AlquilerService {

	int insertOne(Alquiler alquiler);
	int deleteOne(int idAlquiler);
	Alquiler findById(int idAlquiler);
	List<Alquiler> findall();
}
