package viviendas.modelo.service;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import viviendas.modelo.entities.Opiniones;
import viviendas.modelo.entities.Solicitudes;

@Repository
public interface OpinionesService {

	int insertOne(Opiniones opinion);
	int deleteOne(int idOpinion);
	Opiniones findById(int idOpinion);
	List<Opiniones> findall();
	List<Opiniones> findByUsuario(int idUsuario);
	List<Opiniones> findByVivienda(int idVivienda);
	int sumValoraciones(int idVivienda);
	int countFilas(int idVivienda);
	int updateOne(Opiniones opinion);
}
