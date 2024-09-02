package viviendas.modelo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import viviendas.modelo.entities.Usuarios;
import viviendas.modelo.repository.UsuariosRepository;

@Repository
public class UsuariosServiceImpl implements UsuariosService{

	@Autowired
	private UsuariosRepository usuariosRepository;

	@Override
	public int insertOne(Usuarios usuario) {
		try {
			usuariosRepository.save(usuario);
			return 1;
		} catch (Exception e) {
			// TODO: handle exception
			e.getMessage();
			return 0;
		}
	}

	@Override
	public Usuarios findByUsernameAndPassword(String username, String password) {
		// TODO Auto-generated method stub
		return usuariosRepository.findByUsernameAndPassword(username, password);
	}

	@Override
	public Usuarios findById(int idUsuario) {
		// TODO Auto-generated method stub
		return usuariosRepository.findById(idUsuario).orElse(null);
	}
}
