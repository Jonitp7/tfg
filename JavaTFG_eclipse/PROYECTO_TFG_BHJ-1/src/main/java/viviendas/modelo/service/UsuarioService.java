package viviendas.modelo.service;

import org.springframework.stereotype.Repository;

import viviendas.modelo.entities.Usuario;
@Repository
public interface UsuarioService {

	int insertOne(Usuario usuario);
	Usuario findByUsernameAndPassword(String username, String password);
	Usuario findByUsername(String username);
}
