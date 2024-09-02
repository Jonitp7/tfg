package viviendas.modelo.service;

import org.springframework.stereotype.Repository;

import viviendas.modelo.entities.Usuarios;

@Repository
public interface UsuariosService {

	int insertOne(Usuarios usuario);
	Usuarios findById(int idUsuario);
	Usuarios findByUsernameAndPassword(String username, String password);
}
