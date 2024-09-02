package viviendas.modelo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import viviendas.modelo.entities.Pujas;
import viviendas.modelo.repository.PujasRepository;

@Repository
public class PujasServiceImpl implements PujasService{
	
	@Autowired
	private PujasRepository pujaRepository;

	@Override
	public int insertOne(Pujas puja) {
		// TODO Auto-generated method stub
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
		// TODO Auto-generated method stub
		try {
			pujaRepository.deleteById(idPuja);
			return 1;
		} catch (Exception e) {
			// TODO: handle exception
			return 0;
		}
	}

	@Override
	public List<Pujas> findAll() {
		// TODO Auto-generated method stub
		return pujaRepository.findAll();
	}

	

	@Override
	public Pujas findById(int idPuja) {
		// TODO Auto-generated method stub
		return pujaRepository.findById(idPuja).orElse(null);
	}

	@Override
	public List<Pujas> findByUsuario(int idUsuario) {
		// TODO Auto-generated method stub
		return pujaRepository.findByUsuario(idUsuario);
	}

	@Override
	public List<Pujas> findByVivienda(int idVivienda) {
		// TODO Auto-generated method stub
		return pujaRepository.findByVivienda(idVivienda);
	}

}
