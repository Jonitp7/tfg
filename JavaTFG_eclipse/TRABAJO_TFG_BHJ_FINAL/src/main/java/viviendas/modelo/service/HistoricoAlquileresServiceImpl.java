package viviendas.modelo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import viviendas.modelo.entities.HistoricoAlquileres;
import viviendas.modelo.repository.HistoricoAlquileresRepository;

@Repository
public class HistoricoAlquileresServiceImpl implements HistoricoAlquileresService{

	@Autowired
	private HistoricoAlquileresRepository histalquilerRepository;
	
	@Override
	public int insertOne(HistoricoAlquileres historicoAlquileres) {
		// TODO Auto-generated method stub
		try {
			histalquilerRepository.save(historicoAlquileres);
			return 1;
		} catch (Exception e) {
			// TODO: handle exception
			return 0;
		}
	}

	@Override
	public int deleteOne(int idHistoricoAlquileres) {
		// TODO Auto-generated method stub
		try {
			histalquilerRepository.deleteById(idHistoricoAlquileres);
			return 1;
		} catch (Exception e) {
			// TODO: handle exception
			return 0;
		}
	}

	@Override
	public HistoricoAlquileres findById(int idHistoricoAlquileres) {
		// TODO Auto-generated method stub
		return histalquilerRepository.findById(idHistoricoAlquileres).orElse(null);
	}

	@Override
	public List<HistoricoAlquileres> findall() {
		// TODO Auto-generated method stub
		return histalquilerRepository.findAll();
	}

	@Override
	public List<HistoricoAlquileres> findByUsuario(int idUsuario) {
		// TODO Auto-generated method stub
		return histalquilerRepository.findByUsuario(idUsuario);
	}

	@Override
	public List<HistoricoAlquileres> findByVivienda(int idVivienda) {
		// TODO Auto-generated method stub
		return histalquilerRepository.findByVivienda(idVivienda);
	}

}
