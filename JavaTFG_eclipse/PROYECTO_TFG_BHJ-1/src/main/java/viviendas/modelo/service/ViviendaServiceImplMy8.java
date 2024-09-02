package viviendas.modelo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import viviendas.modelo.entities.Vivienda;
import viviendas.modelo.repository.ViviendaRepository;

@Repository
public class ViviendaServiceImplMy8 implements ViviendaService{
	
	@Autowired
	private ViviendaRepository viviendaRepository;

	@Override
	public int insertOne(Vivienda vivienda) {
		try {
			viviendaRepository.save(vivienda);
			return 1;
		} catch (Exception e) {
			// TODO: handle exception
			return 0;
		}
	}

	@Override
	public int deleteOne(int idVivienda) {
		try {
			viviendaRepository.deleteById(idVivienda);
			return 1;
		} catch (Exception e) {
			// TODO: handle exception
			return 0;
		}
	}

	@Override
	public int updateOne(Vivienda vivienda) {
		try {
			viviendaRepository.save(vivienda);
			return 1;
		} catch (Exception e) {
			// TODO: handle exception
			return 0;
		}
	}

	@Override
	public List<Vivienda> findAll() {
		// TODO Auto-generated method stub
		return viviendaRepository.findAll();
	}

	@Override
	public List<Vivienda> findByPrecio(int precio) {
		// TODO Auto-generated method stub
		return viviendaRepository.findByPrecio(precio);
	}

	@Override
	public List<Vivienda> findByubicacion(String ubicacion) {
		// TODO Auto-generated method stub
		return viviendaRepository.findByubicacion(ubicacion);
	}

	@Override
	public List<Vivienda> findByExtension(int extension) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Vivienda> findByBaños(int baños) {
		// TODO Auto-generated method stub
		return viviendaRepository.findByBaños(baños);
	}

	@Override
	public List<Vivienda> findByHabitacinoes(int habitaciones) {
		// TODO Auto-generated method stub
		return viviendaRepository.findByHabitacinoes(habitaciones);
	}

	@Override
	public List<Vivienda> findByGaraje(boolean garaje) {
		// TODO Auto-generated method stub
		return viviendaRepository.findByGaraje(garaje);
	}

	@Override
	public List<Vivienda> findByEstado(String estado) {
		// TODO Auto-generated method stub
		return viviendaRepository.findByEstado(estado);
	}

	@Override
	public List<Vivienda> findByDescripcionContains(String palabra) {
		// TODO Auto-generated method stub
		return viviendaRepository.findByDescripcionContains(palabra);
	}

	@Override
	public List<Vivienda> findByPlantas(int Plantas) {
		// TODO Auto-generated method stub
		return viviendaRepository.findByPlantas(Plantas);
	}

	@Override
	public List<Vivienda> findByAñoConstruccion(int añoConstruccion) {
		// TODO Auto-generated method stub
		return viviendaRepository.findByAñoConstruccion(añoConstruccion);
	}

	@Override
	public List<Vivienda> findByPropietario(int idPropietario) {
		// TODO Auto-generated method stub
		return viviendaRepository.findByPropietario(idPropietario);
	}

	@Override
	public Vivienda findById(int idVivienda) {
		// TODO Auto-generated method stub
		return viviendaRepository.findById(idVivienda).orElse(null);
	}

}
