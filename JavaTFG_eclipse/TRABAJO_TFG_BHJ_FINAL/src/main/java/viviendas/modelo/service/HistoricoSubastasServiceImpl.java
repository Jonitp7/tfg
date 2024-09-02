package viviendas.modelo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import viviendas.modelo.entities.HistoricoSubastas;
import viviendas.modelo.repository.HistoricoSubastasRepository;

@Repository
public class HistoricoSubastasServiceImpl implements HistoricoSubastasService{
	
	@Autowired
	private HistoricoSubastasRepository histsubastasRepository;

	@Override
	public int insertOne(HistoricoSubastas historicoSubastas) {
		// TODO Auto-generated method stub
		try {
			histsubastasRepository.save(historicoSubastas);
			return 1;
		} catch (Exception e) {
			// TODO: handle exception
			return 0;
		}
	}

	@Override
	public int deleteOne(int idHistoricoSubastas) {
		// TODO Auto-generated method stub
		try {
			histsubastasRepository.deleteById(idHistoricoSubastas);
			return 1;
		} catch (Exception e) {
			// TODO: handle exception
			return 0;
		}
	}

	@Override
	public HistoricoSubastas findById(int idHistoricoSubastas) {
		// TODO Auto-generated method stub
		return histsubastasRepository.findById(idHistoricoSubastas).orElse(null);
	}

	@Override
	public List<HistoricoSubastas> findall() {
		// TODO Auto-generated method stub
		return histsubastasRepository.findAll();
	}

	@Override
	public List<HistoricoSubastas> findByUsuario(int idUsuario) {
		// TODO Auto-generated method stub
		return histsubastasRepository.findByUsuario(idUsuario);
	}

	@Override
	public List<HistoricoSubastas> findByVivienda(int idVivienda) {
		// TODO Auto-generated method stub
		return histsubastasRepository.findByVivienda(idVivienda);
	}

}
