package viviendas.modelo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import viviendas.modelo.entities.Alquiler;
import viviendas.modelo.repository.AlquilerRepository;

@Repository
public class AlquilerServiceImplMy8 implements AlquilerService{
	
	@Autowired
	private AlquilerRepository alquilerRepository;

	@Override
	public int insertOne(Alquiler alquiler) {
		try {
			alquilerRepository.save(alquiler);
			return 1;
		} catch (Exception e) {
			// TODO: handle exception
			return 0;
		}
	}

	@Override
	public int deleteOne(int idAlquiler) {
		try {
			alquilerRepository.deleteById(idAlquiler);
			return 1;
		} catch (Exception e) {
			// TODO: handle exception
			return 0;
		}
	}

	@Override
	public Alquiler findById(int idAlquiler) {
		// TODO Auto-generated method stub
		return alquilerRepository.findById(idAlquiler).orElse(null);
	}

	@Override
	public List<Alquiler> findall() {
		// TODO Auto-generated method stub
		return alquilerRepository.findAll();
	}

}
