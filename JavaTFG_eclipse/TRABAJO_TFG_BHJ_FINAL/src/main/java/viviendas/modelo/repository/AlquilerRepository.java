package viviendas.modelo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import viviendas.modelo.entities.Alquileres;

@Repository
public interface AlquilerRepository extends JpaRepository<Alquileres, Integer>{

	@Query("select a FROM Alquileres a WHERE a.usuario.idUsuario = ?1")
	List<Alquileres> findByUsuario(int idUsuario);
	
	@Query("select a FROM Alquileres a WHERE a.vivienda.idVivienda = ?1")
	List<Alquileres> findByVivienda(int idVivienda);
}
