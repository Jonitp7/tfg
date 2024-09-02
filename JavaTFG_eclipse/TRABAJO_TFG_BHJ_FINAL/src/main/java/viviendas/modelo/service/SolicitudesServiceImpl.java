package viviendas.modelo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import viviendas.modelo.entities.Solicitudes;
import viviendas.modelo.repository.SolicitudesRepository;

@Repository
public class SolicitudesServiceImpl implements SolicitudesService{
	
	@Autowired
	private SolicitudesRepository solicitudesRepository;

	@Override
	public int insertOne(Solicitudes solicitud) {
		// TODO Auto-generated method stub
		try {
			solicitudesRepository.save(solicitud);
			return 1;
		} catch (Exception e) {
			// TODO: handle exception
			return 0;
		}
	}

	@Override
	public int deleteOne(int idSolicitud) {
		// TODO Auto-generated method stub
		try {
			solicitudesRepository.deleteById(idSolicitud);
			return 1;
		} catch (Exception e) {
			// TODO: handle exception
			return 0;
		}
	}

	@Override
	public Solicitudes findById(int idSolicitud) {
		// TODO Auto-generated method stub
		return solicitudesRepository.findById(idSolicitud).orElse(null);
	}

	@Override
	public List<Solicitudes> findall() {
		// TODO Auto-generated method stub
		return solicitudesRepository.findAll();
	}

	@Override
	public int updateOne(Solicitudes solicitud) {
		// TODO Auto-generated method stub
		try {
			solicitudesRepository.save(solicitud);
			return 1;
		} catch (Exception e) {
			// TODO: handle exception
			return 0;
		}
	}

	@Override
	public List<Solicitudes> findByIdUsuario(int idUsuario) {
		// TODO Auto-generated method stub
		return solicitudesRepository.findByIdUsuario(idUsuario);
	}

}
