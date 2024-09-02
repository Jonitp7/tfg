package viviendas.modelo.service;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import viviendas.modelo.entities.Favoritos;
import viviendas.modelo.entities.Roles;


@Repository
public interface FavoritosService {

	int insertOne(Favoritos favoritos);
	int deleteOne(int idFavorito);
	Favoritos findById(int idFavorito);
	List<Favoritos> findall();
	List<Favoritos> findByVivienda(int idVivienda);
	List<Favoritos> findByUsuario(int idUsuario);
}
