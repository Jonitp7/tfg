package viviendas.modelo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import viviendas.modelo.entities.Puja;
import viviendas.modelo.repository.PujaRepository;

@Repository
public class PujaServiceImplMy8 implements PujaService{
	
	@Autowired
	private PujaRepository pujaRepository;

	@Override
	public int insertOne(Puja puja) {
		try {
			pujaRepository.save(puja);
			return 1;
		} catch (Exception e) {
			// TODO: handle exception
			return 0;
		}
	}

	@Override
	public int deleteOne(int idPuja) {
		try {
			pujaRepository.deleteById(idPuja);
			return 1;
		} catch (Exception e) {
			// TODO: handle exception
			return 0;
		}
	}

	@Override
	public List<Puja> findAll() {
		// TODO Auto-generated method stub
		return pujaRepository.findAll();
	}

	@Override
	public List<Puja> findByComprador(int idPostor) {
		// TODO Auto-generated method stub
		return pujaRepository.findByComprador(idPostor);
	}

	@Override
	public List<Puja> findBySubasta(int idSubasta) {
		// TODO Auto-generated method stub
		return pujaRepository.findBySubasta(idSubasta);
	}

	@Override
	public Puja findById(int idPuja) {
		// TODO Auto-generated method stub
		return pujaRepository.findById(idPuja).orElse(null);
	}

}
