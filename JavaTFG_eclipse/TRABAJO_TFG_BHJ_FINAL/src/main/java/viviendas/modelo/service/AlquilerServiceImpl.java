package viviendas.modelo.service;

import java.util.List;
import java.util.Optional;
import java.util.function.Function;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.query.FluentQuery.FetchableFluentQuery;
import org.springframework.stereotype.Repository;

import viviendas.modelo.entities.Alquileres;
import viviendas.modelo.repository.AlquilerRepository;
@Repository
public class AlquilerServiceImpl implements AlquilerService{
	
	@Autowired
	private AlquilerRepository alquilerRepository;

	@Override
	public int insertOne(Alquileres alquileres) {
		// TODO Auto-generated method stub
		try {
			alquilerRepository.save(alquileres);
			return 1;
		} catch (Exception e) {
			// TODO: handle exception
			return 0;
		}
	}

	@Override
	public int deleteOne(int idAlquiler) {
		// TODO Auto-generated method stub
		try {
			alquilerRepository.deleteById(idAlquiler);
			return 1;
		} catch (Exception e) {
			// TODO: handle exception
			return 0;
		}
	}

	@Override
	public Alquileres findById(int idAlquiler) {
		// TODO Auto-generated method stub
		return alquilerRepository.findById(idAlquiler).orElse(null);
	}

	@Override
	public List<Alquileres> findAll() {
		// TODO Auto-generated method stub
		return alquilerRepository.findAll();
	}

	@Override
	public List<Alquileres> findByUsuario(int idUsuario) {
		// TODO Auto-generated method stub
		return alquilerRepository.findByUsuario(idUsuario);
	}

	@Override
	public List<Alquileres> findByVivienda(int idVivienda) {
		// TODO Auto-generated method stub
		return alquilerRepository.findByVivienda(idVivienda);
	}

	

}
