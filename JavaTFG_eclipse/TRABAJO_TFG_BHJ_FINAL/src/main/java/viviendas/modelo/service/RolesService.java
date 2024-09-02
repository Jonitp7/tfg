package viviendas.modelo.service;

import java.util.List;

import org.springframework.stereotype.Repository;

import viviendas.modelo.entities.Roles;
@Repository
public interface RolesService {

	int insertOne(Roles rol);
	int deleteOne(int idRol);
	Roles findById(int idRol);
	List<Roles> findall();
	List<Roles> findByUsuario(int idUsuario);
}
