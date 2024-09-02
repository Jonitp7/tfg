package viviendas.modelo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import viviendas.modelo.entities.Chatbox;
import viviendas.modelo.entities.Viviendas;

@Repository
public interface ViviendasRepository extends JpaRepository<Viviendas, Integer>, JpaSpecificationExecutor<Viviendas> {

	
	
	@Query("select v from Viviendas v where v.extension = ?1")
	List<Viviendas> findByExtension(int extension);
	
	@Query("select v from Viviendas v where v.ubicacion = ?1")
	List<Viviendas> findByubicacion(String ubicacion);

	
	@Query("select v from Viviendas v where v.aseos = ?1")
	List<Viviendas> findByAseos(int aseos);
	
	@Query("select v from Viviendas v where v.habitaciones = ?1")
	List<Viviendas> findByHabitacinoes(int habitaciones);
	
	@Query("select v from Viviendas v where v.garaje = ?1")
	List<Viviendas> findByGaraje(boolean garaje);
	
	
	@Query("select v from Viviendas v where v.descripcion like %?1%")
	List<Viviendas> findByDescripcionContains(String palabra);
	
	@Query("select v from Viviendas v where v.plantas = ?1")
	List<Viviendas> findByPlantas(int Plantas);
	
	@Query("select v from Viviendas v where v.fechaConstruccion = ?1")
	List<Viviendas> findByFechaConstruccion(int fechaConstruccion);
	
	@Query("select v from Viviendas v where v.usuario.idUsuario= ?1")
	List<Viviendas> findByUsuario(int idUsuario);
	
	
	
}
