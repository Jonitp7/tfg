package viviendas.modelo.service;

import java.util.List;

import org.springframework.stereotype.Repository;

import viviendas.modelo.entities.Viviendas;

@Repository
public interface VIviendasService {

	int insertOne(Viviendas vivienda);
	int deleteOne(int idVivienda);
	int updateOne(Viviendas vivienda);
	List<Viviendas> findAll();
	Viviendas findById(int idVivienda);
	List<Viviendas> findByubicacion(String ubicacion);
	List<Viviendas> findByExtension(int extension);
	List<Viviendas> findByAseos(int aseos);
	List<Viviendas> findByHabitacinoes(int habitaciones);
	List<Viviendas> findByGaraje(boolean garaje);
	List<Viviendas> findByDescripcionContains(String palabra);
	List<Viviendas> findByPlantas(int Plantas);
	List<Viviendas> findByFechaConstruccion(int fechaConstruccion);
	List<Viviendas> findByUsuario(int idUsuario);
}
