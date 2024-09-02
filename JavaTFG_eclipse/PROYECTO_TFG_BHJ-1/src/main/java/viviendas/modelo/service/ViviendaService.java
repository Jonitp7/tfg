package viviendas.modelo.service;

import java.util.List;

import org.springframework.stereotype.Repository;

import viviendas.modelo.entities.Vivienda;
@Repository
public interface ViviendaService {

	int insertOne(Vivienda vivienda);
	int deleteOne(int idVivienda);
	int updateOne(Vivienda vivienda);
	List<Vivienda> findAll();
	Vivienda findById(int idVivienda);
	List<Vivienda> findByPrecio(int precio);
	List<Vivienda> findByubicacion(String ubicacion);
	List<Vivienda> findByExtension(int extension);
	List<Vivienda> findByBaños(int baños);
	List<Vivienda> findByHabitacinoes(int habitaciones);
	List<Vivienda> findByGaraje(boolean garaje);
	List<Vivienda> findByEstado(String estado);
	List<Vivienda> findByDescripcionContains(String palabra);
	List<Vivienda> findByPlantas(int Plantas);
	List<Vivienda> findByAñoConstruccion(int añoConstruccion);
	List<Vivienda> findByPropietario(int idPropietario);
	
}
