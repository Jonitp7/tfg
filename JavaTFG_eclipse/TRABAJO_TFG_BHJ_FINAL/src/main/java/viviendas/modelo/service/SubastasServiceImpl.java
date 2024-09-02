package viviendas.modelo.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import viviendas.modelo.entities.Alquileres;
import viviendas.modelo.entities.Subastas;
import viviendas.modelo.repository.SubastasRepository;

@Repository
public class SubastasServiceImpl  implements SubastasService{

	@Autowired
	private SubastasRepository subastasRepository;

	@Override
	public int insertOne(Subastas subasta) {
		try {
			subastasRepository.save(subasta);
			return 1;
		} catch (Exception e) {
			// TODO: handle exception
			return 0;
		}
	}

	@Override
	public int deleteOne(int idSubasta) {
		try {
			subastasRepository.deleteById(idSubasta);
			return 1;
		} catch (Exception e) {
			// TODO: handle exception
			return 0;
		}
	}


	@Override
	public Subastas findById(int idSubasta) {
		// TODO Auto-generated method stub
		return subastasRepository.findById(idSubasta).orElse(null);
	}

	@Override
	public List<Subastas> findAll() {
		// TODO Auto-generated method stub
		return subastasRepository.findAll();
	}

	@Override
	public List<Subastas> findByUsuario(int idUsuario) {
		// TODO Auto-generated method stub
		return subastasRepository.findByUsuario(idUsuario);
	}

	@Override
	public List<Subastas> findByVivienda(int idVivienda) {
		// TODO Auto-generated method stub
		return subastasRepository.findByVivienda(idVivienda);
	}
}
