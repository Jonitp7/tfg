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

import viviendas.modelo.entities.Alquileres;
import viviendas.modelo.entities.Chatbox;
import viviendas.modelo.entities.Subastas;
import viviendas.modelo.service.SubastasService;
import viviendas.modelo.service.UsuariosService;
import viviendas.modelo.service.VIviendasService;

@RestController
@CrossOrigin( origins = "*")
@RequestMapping("/subastas")
public class SubastasController {

	@Autowired
	private UsuariosService usuarioService;
	
	@Autowired
	private VIviendasService viviendaService;
	
	@Autowired
	private SubastasService subastaService;
	
	@GetMapping("/todas")
	public List<Subastas> findAll(){
		return subastaService.findAll();
	}
	@GetMapping("/porId/{idSubasta}")
	public Subastas findById(@PathVariable int idSubasta) {
		return subastaService.findById(idSubasta);
	}
	@GetMapping("/porUsuario/{idUsuario}")
	public List<Subastas> findByUsuario(@PathVariable int idUsuario) {
		return subastaService.findByUsuario(idUsuario);
	}
	@GetMapping("/porVivienda/{idVivienda}")
	public List<Subastas> findByVivienda(@PathVariable int idVivienda){
		return subastaService.findByVivienda(idVivienda);
	}
	
	@PostMapping("/insertar/{idUsuario}/{idVivienda}")
	public int insertOne(@RequestBody Subastas subasta, @PathVariable int idUsuario, @PathVariable int idVivienda) {
		subasta.setUsuario(usuarioService.findById(idUsuario));
		subasta.setVivienda(viviendaService.findById(idVivienda));
		return subastaService.insertOne(subasta);
	}
	
	@DeleteMapping("/eliminar/{idSubasta}")
	public int deleteOne(@PathVariable int idSubasta) {
		return subastaService.deleteOne(idSubasta);
	}
	
}
