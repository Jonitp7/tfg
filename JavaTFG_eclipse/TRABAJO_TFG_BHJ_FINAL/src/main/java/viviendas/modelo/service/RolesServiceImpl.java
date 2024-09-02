package viviendas.modelo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import viviendas.modelo.entities.Roles;
import viviendas.modelo.repository.RolesRepository;

@Repository
public class RolesServiceImpl implements RolesService{

	@Autowired
	private RolesRepository rolesRepository;
	
	@Override
	public int insertOne(Roles rol) {
		// TODO Auto-generated method stub
		try {
			rolesRepository.save(rol);
			return 1;
		} catch (Exception e) {
			// TODO: handle exception
			return 0;
		}
	}

	@Override
	public int deleteOne(int idRol) {
		// TODO Auto-generated method stub
		try {
			rolesRepository.deleteById(idRol);
			return 1;
		} catch (Exception e) {
			// TODO: handle exception
			return 0;
		}
	}

	@Override
	public Roles findById(int idRol) {
		// TODO Auto-generated method stub
		return rolesRepository.findById(idRol).orElse(null);
	}

	@Override
	public List<Roles> findall() {
		// TODO Auto-generated method stub
		return rolesRepository.findAll();
	}

	@Override
	public List<Roles> findByUsuario(int idUsuario) {
		// TODO Auto-generated method stub
		return rolesRepository.findByUsuario(idUsuario);
	}

}
