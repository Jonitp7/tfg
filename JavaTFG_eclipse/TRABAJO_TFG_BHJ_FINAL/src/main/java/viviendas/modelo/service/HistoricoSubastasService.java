package viviendas.modelo.service;

import java.util.List;

import org.springframework.stereotype.Repository;

import viviendas.modelo.entities.HistoricoAlquileres;
import viviendas.modelo.entities.HistoricoSubastas;

@Repository
public interface HistoricoSubastasService {

	int insertOne(HistoricoSubastas historicoSubastas);
	int deleteOne(int idHistoricoSubastas);
	HistoricoSubastas findById(int idHistoricoSubastas);
	List<HistoricoSubastas> findall();
	List<HistoricoSubastas> findByUsuario(int idUsuario);
	List<HistoricoSubastas> findByVivienda(int idVivienda);
}
