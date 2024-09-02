package viviendas.modelo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import viviendas.modelo.entities.Favoritos;
import viviendas.modelo.service.FavoritosService;
import viviendas.modelo.service.UsuariosService;
import viviendas.modelo.service.VIviendasService;

@RestController
@CrossOrigin( origins = "*")
@RequestMapping("/favoritos")
public class FavoritosController {

	@Autowired
	private FavoritosService favoritoService;
	
	@Autowired
	private VIviendasService viviendaService;
	
	@Autowired
	private UsuariosService usuarioService;
	
	@PostMapping("/insertar/{idVivienda}/{idUsuario}")
	public int insertOne(@PathVariable int idVivienda, @PathVariable int idUsuario) {
		Favoritos favorito = new Favoritos();
		favorito.setVivienda(viviendaService.findById(idVivienda));
		favorito.setUsuario(usuarioService.findById(idUsuario));
		return favoritoService.insertOne(favorito);
	}
	
	@GetMapping("/todos")
	public List<Favoritos> findAll(){
		return favoritoService.findall();
	}
	
	@GetMapping("/porUsuario/{idUsuario}")
	public List<Favoritos> findByUsuario(@PathVariable int idUsuario){
		return favoritoService.findByUsuario(idUsuario);
	}
	
	@GetMapping("/porVivienda/{idVivienda}")
	public List<Favoritos> findByVivienda(@PathVariable int idVivienda){
		return favoritoService.findByVivienda(idVivienda);
	}
	
	@DeleteMapping("/eliminar/{idFavorito}")
	public int deleteOne(@PathVariable int idFavorito) {
		return favoritoService.deleteOne(idFavorito);
	}
	
	
}
