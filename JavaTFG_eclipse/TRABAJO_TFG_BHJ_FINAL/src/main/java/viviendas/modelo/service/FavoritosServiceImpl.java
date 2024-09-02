package viviendas.modelo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import viviendas.modelo.entities.Favoritos;
import viviendas.modelo.entities.Roles;
import viviendas.modelo.repository.FavoritosRepository;

@Repository
public class FavoritosServiceImpl implements FavoritosService{
	
	@Autowired
	private FavoritosRepository favoritosRepository;

	@Override
	public int insertOne(Favoritos favoritos) {
		// TODO Auto-generated method stub
		try {
			favoritosRepository.save(favoritos);
			return 1;
		} catch (Exception e) {
			// TODO: handle exception
			return 0;
		}
	}

	@Override
	public int deleteOne(int idFavorito) {
		// TODO Auto-generated method stub
		try {
			favoritosRepository.deleteById(idFavorito);
			return 1;
		} catch (Exception e) {
			// TODO: handle exception
			return 0;
		}
	}

	@Override
	public Favoritos findById(int idFavorito) {
		// TODO Auto-generated method stub
		return favoritosRepository.findById(idFavorito).orElse(null);
	}

	@Override
	public List<Favoritos> findall() {
		// TODO Auto-generated method stub
		return favoritosRepository.findAll();
	}

	@Override
	public List<Favoritos> findByVivienda(int idVivienda) {
		// TODO Auto-generated method stub
		return favoritosRepository.findByVivienda(idVivienda);
	}

	@Override
	public List<Favoritos> findByUsuario(int idUsuario) {
		// TODO Auto-generated method stub
		return favoritosRepository.findByUsuario(idUsuario);
	}

	
}
