package viviendas.modelo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import viviendas.modelo.entities.Favorito;

public interface FavoritoRepostiory extends JpaRepository<Favorito, Integer>{

	//propietario venta puja subasta
	
}
