package viviendas.modelo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import viviendas.modelo.entities.Favoritos;

@Repository
public interface FavoritosRepository extends JpaRepository<Favoritos, Integer>{

	@Query("select f FROM Favoritos f WHERE f.usuario.idUsuario = ?1")
	List<Favoritos> findByUsuario(int idUsuario);
	
	@Query("select f FROM Favoritos f WHERE f.vivienda.idVivienda = ?1")
	List<Favoritos> findByVivienda(int idVivienda);
}
