package viviendas.modelo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import viviendas.modelo.entities.Usuario;
import viviendas.modelo.repository.UsuarioRepository;

@Repository
public class UsuarioServiceImplMy8 implements UsuarioService{
	
	@Autowired
	private UsuarioRepository usuarioRepository;

	@Override
	public int insertOne(Usuario usuario) {
		try {
			usuarioRepository.save(usuario);
			return 1;
		} catch (Exception e) {
			// TODO: handle exception
			e.getMessage();
			return 0;
		}
	}

	@Override
	public Usuario findByUsernameAndPassword(String username, String password) {
		// TODO Auto-generated method stub
		return usuarioRepository.findByUsernameAndPassword(username, password);
	}

	@Override
	public Usuario findByUsername(String username) {
		// TODO Auto-generated method stub
		return usuarioRepository.findById(username).orElse(null);
	}

}
