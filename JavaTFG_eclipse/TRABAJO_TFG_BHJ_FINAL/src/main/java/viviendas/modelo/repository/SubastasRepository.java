package viviendas.modelo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import viviendas.modelo.entities.Subastas;

@Repository
public interface SubastasRepository extends JpaRepository<Subastas, Integer>{

	@Query("select s FROM Subastas s WHERE s.usuario.idUsuario = ?1")
	List<Subastas> findByUsuario(int idUsuario);
	
	@Query("select s FROM Subastas s WHERE s.vivienda.idVivienda = ?1")
	List<Subastas> findByVivienda(int idVivienda);
}
