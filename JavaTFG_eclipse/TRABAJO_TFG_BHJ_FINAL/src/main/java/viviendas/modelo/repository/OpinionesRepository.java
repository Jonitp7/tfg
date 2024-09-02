package viviendas.modelo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import viviendas.modelo.entities.Opiniones;

@Repository
public interface OpinionesRepository extends JpaRepository<Opiniones, Integer>{

	@Query("select o FROM Opiniones o WHERE o.usuario.idUsuario = ?1")
	List<Opiniones> findByUsuario(int idUsuario);
	
	@Query("select o FROM Opiniones o WHERE o.vivienda.idVivienda = ?1")
	List<Opiniones> findByVivienda(int idVivienda);
	
	@Query("select sum(o.valoracion) FROM Opiniones o WHERE o.vivienda.idVivienda = ?1")
	int sumValoraciones(int idVivienda);
	
	@Query("select count(o) FROM Opiniones o WHERE o.vivienda.idVivienda= ?1")
	int countFilas(int idVivienda);
}
