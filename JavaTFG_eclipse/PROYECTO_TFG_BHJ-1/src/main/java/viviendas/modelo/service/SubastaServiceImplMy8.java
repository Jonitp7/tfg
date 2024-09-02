package viviendas.modelo.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import viviendas.modelo.entities.Subasta;
import viviendas.modelo.repository.SubastaRepository;

@Repository
public class SubastaServiceImplMy8 implements SubastaService{
	
	@Autowired
	private SubastaRepository subastaRepository;

	@Override
	public int insertOne(Subasta subasta) {
		try {
			subastaRepository.save(subasta);
			return 1;
		} catch (Exception e) {
			// TODO: handle exception
			return 0;
		}
	}

	@Override
	public int deleteOne(int idSubasta) {
		try {
			subastaRepository.deleteById(idSubasta);
			return 1;
		} catch (Exception e) {
			// TODO: handle exception
			return 0;
		}
	}

	@Override
	public List<Subasta> findbyFechaInicio(Date fechaI) {
		// TODO Auto-generated method stub
		return subastaRepository.findbyFechaInicio(fechaI);
	}

	@Override
	public List<Subasta> findbyFechaFin(Date fechaF) {
		// TODO Auto-generated method stub
		return subastaRepository.findbyFechaFin(fechaF);
	}

	@Override
	public Subasta findById(int idSubasta) {
		// TODO Auto-generated method stub
		return subastaRepository.findById(idSubasta).orElse(null);
	}

	@Override
	public List<Subasta> findAll() {
		// TODO Auto-generated method stub
		return subastaRepository.findAll();
	}

}
