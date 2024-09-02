package viviendas.modelo.service;

import java.util.List;

import org.springframework.stereotype.Repository;

import viviendas.modelo.entities.Solicitudes;

@Repository
public interface SolicitudesService {

	int insertOne(Solicitudes solicitud);
	int deleteOne(int idSolicitud);
	int updateOne(Solicitudes solicitud);
	Solicitudes findById(int idSolicitud);
	List<Solicitudes> findall();
	List<Solicitudes> findByIdUsuario(int idUsuario);
}
