package viviendas.modelo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import viviendas.modelo.entities.Propietario;
import viviendas.modelo.repository.PropietarioRepository;

@Repository
public class PropietarioServiceImplMy8 implements PropietarioService{
	
	@Autowired
	private PropietarioRepository propietarioRepository;

	@Override
	public int insertOne(Propietario propietario) {
		try {
			propietarioRepository.save(propietario);
			return 1;
		} catch (Exception e) {
			// TODO: handle exception
			return 0;
		}
	}

	@Override
	public Propietario findById(int idPropietario) {
		// TODO Auto-generated method stub
		return propietarioRepository.findById(idPropietario).orElse(null);
	}

	@Override
	public List<Propietario> findAll() {
		// TODO Auto-generated method stub
		return propietarioRepository.findAll();
	}

}
