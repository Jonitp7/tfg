package viviendas.modelo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import viviendas.modelo.entities.Viviendas;
import viviendas.modelo.repository.ViviendasRepository;


@Repository
public class ViviendasServiceImpl implements VIviendasService{

	@Autowired
	private ViviendasRepository viviendasRepository;

	@Override
	public int insertOne(Viviendas vivienda) {
		try {
			viviendasRepository.save(vivienda);
			return 1;
		} catch (Exception e) {
			// TODO: handle exception
			return 0;
		}
	}

	@Override
	public int deleteOne(int idVivienda) {
		try {
			viviendasRepository.deleteById(idVivienda);
			return 1;
		} catch (Exception e) {
			// TODO: handle exception
			return 0;
		}
	}

	@Override
	public int updateOne(Viviendas vivienda) {
		try {
			viviendasRepository.save(vivienda);
			return 1;
		} catch (Exception e) {
			// TODO: handle exception
			return 0;
		}
	}

	@Override
	public List<Viviendas> findAll() {
		// TODO Auto-generated method stub
		return viviendasRepository.findAll();
	}


	@Override
	public List<Viviendas> findByubicacion(String ubicacion) {
		// TODO Auto-generated method stub
		return viviendasRepository.findByubicacion(ubicacion);
	}

	@Override
	public List<Viviendas> findByExtension(int extension) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Viviendas> findByAseos(int aseos) {
		// TODO Auto-generated method stub
		return viviendasRepository.findByAseos(aseos);
	}

	@Override
	public List<Viviendas> findByHabitacinoes(int habitaciones) {
		// TODO Auto-generated method stub
		return viviendasRepository.findByHabitacinoes(habitaciones);
	}

	@Override
	public List<Viviendas> findByGaraje(boolean garaje) {
		// TODO Auto-generated method stub
		return viviendasRepository.findByGaraje(garaje);
	}

	

	@Override
	public List<Viviendas> findByDescripcionContains(String palabra) {
		// TODO Auto-generated method stub
		return viviendasRepository.findByDescripcionContains(palabra);
	}

	@Override
	public List<Viviendas> findByPlantas(int Plantas) {
		// TODO Auto-generated method stub
		return viviendasRepository.findByPlantas(Plantas);
	}

	@Override
	public List<Viviendas> findByFechaConstruccion(int fechaConstruccion) {
		// TODO Auto-generated method stub
		return viviendasRepository.findByFechaConstruccion(fechaConstruccion);
	}

	
	@Override
	public Viviendas findById(int idVivienda) {
		// TODO Auto-generated method stub
		return viviendasRepository.findById(idVivienda).orElse(null);
	}

	@Override
	public List<Viviendas> findByUsuario(int idUsuario) {
		// TODO Auto-generated method stub
		return viviendasRepository.findByUsuario(idUsuario);
	}
}
