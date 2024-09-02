package viviendas.modelo.service;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import viviendas.modelo.entities.HistoricoAlquileres;

@Repository
public interface HistoricoAlquileresService {

	int insertOne(HistoricoAlquileres historicoAlquileres);
	int deleteOne(int idHistoricoAlquileres);
	HistoricoAlquileres findById(int idHistoricoAlquileres);
	List<HistoricoAlquileres> findall();
	List<HistoricoAlquileres> findByUsuario(int idUsuario);
	List<HistoricoAlquileres> findByVivienda(int idVivienda);
}
