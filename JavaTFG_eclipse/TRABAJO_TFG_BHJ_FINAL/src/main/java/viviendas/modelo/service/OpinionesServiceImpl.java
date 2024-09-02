package viviendas.modelo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import viviendas.modelo.entities.Opiniones;
import viviendas.modelo.repository.OpinionesRepository;

@Repository
public class OpinionesServiceImpl implements OpinionesService{
	
	@Autowired
	private OpinionesRepository opinionesRepository;
	

	@Override
	public int insertOne(Opiniones opinion) {
		// TODO Auto-generated method stub
		try {
			opinionesRepository.save(opinion);
			return 1;
		} catch (Exception e) {
			// TODO: handle exception
			return 0;
		}
	}

	@Override
	public int deleteOne(int idOpinion) {
		// TODO Auto-generated method stub
		try {
			opinionesRepository.deleteById(idOpinion);
			return 1;
		} catch (Exception e) {
			// TODO: handle exception
			return 0;
		}
	}

	@Override
	public Opiniones findById(int idOpinion) {
		// TODO Auto-generated method stub
		return opinionesRepository.findById(idOpinion).orElse(null);
	}

	@Override
	public List<Opiniones> findall() {
		// TODO Auto-generated method stub
		return opinionesRepository.findAll();
	}

	@Override
	public List<Opiniones> findByUsuario(int idUsuario) {
		// TODO Auto-generated method stub
		return opinionesRepository.findByUsuario(idUsuario);
	}

	@Override
	public List<Opiniones> findByVivienda(int idVivienda) {
		// TODO Auto-generated method stub
		return opinionesRepository.findByVivienda(idVivienda);
	}

	@Override
	public int sumValoraciones(int idVivienda) {
		// TODO Auto-generated method stub
		return opinionesRepository.sumValoraciones(idVivienda);
	}

	@Override
	public int countFilas(int idVivienda) {
		// TODO Auto-generated method stub
		return opinionesRepository.countFilas(idVivienda);
	}

	@Override
	public int updateOne(Opiniones opinion) {
		// TODO Auto-generated method stub
		try {
			opinionesRepository.save(opinion);
			return 1;
		} catch (Exception e) {
			// TODO: handle exception
			return 0;
		}
	}

}
