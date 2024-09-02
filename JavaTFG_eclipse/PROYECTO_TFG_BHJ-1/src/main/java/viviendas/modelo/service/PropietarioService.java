package viviendas.modelo.service;

import java.util.List;

import org.springframework.stereotype.Repository;

import viviendas.modelo.entities.Propietario;
@Repository
public interface PropietarioService {

	int insertOne(Propietario propietario);
	Propietario findById(int idPropietario);
	List<Propietario> findAll();

}
