package viviendas.modelo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import viviendas.modelo.entities.Vivienda;
@Repository
public interface ViviendaRepository extends JpaRepository<Vivienda, Integer>{

	@Query("select v from Vivienda v where v.precio between 0 and ?1")
	List<Vivienda> findByPrecio(int precio);
	
	@Query("select v from Vivienda v where v.ubicacion = ?1")
	List<Vivienda> findByubicacion(String ubicacion);
	
	/*@Query("select v from Vivienda v where v.extension between 0 and ?1")
	List<Vivienda> findByExtension(int extension);*/
	
	@Query("select v from Vivienda v where v.baños = ?1")
	List<Vivienda> findByBaños(int baños);
	
	@Query("select v from Vivienda v where v.habitaciones = ?1")
	List<Vivienda> findByHabitacinoes(int habitaciones);
	
	@Query("select v from Vivienda v where v.garaje = ?1")
	List<Vivienda> findByGaraje(boolean garaje);
	
	@Query("select v from Vivienda v where v.estado = ?1")
	List<Vivienda> findByEstado(String estado);
	
	@Query("select v from Vivienda v where v.descripcion like %?1%")
	List<Vivienda> findByDescripcionContains(String palabra);
	
	@Query("select v from Vivienda v where v.plantas = ?1")
	List<Vivienda> findByPlantas(int Plantas);
	
	@Query("select v from Vivienda v where v.añoConstruccion = ?1")
	List<Vivienda> findByAñoConstruccion(int añoConstruccion);
	
	@Query("select v from Vivienda v where v.propietario.idPropietario = ?1")
	List<Vivienda> findByPropietario(int idPropietario);
}
