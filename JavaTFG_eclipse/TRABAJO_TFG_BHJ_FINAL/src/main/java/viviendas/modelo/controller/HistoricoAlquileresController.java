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
import viviendas.modelo.entities.HistoricoAlquileres;
import viviendas.modelo.service.AlquilerService;
import viviendas.modelo.service.HistoricoAlquileresService;
import viviendas.modelo.service.UsuariosService;
import viviendas.modelo.service.VIviendasService;

@RestController
@CrossOrigin( origins = "*")
@RequestMapping("/historicoAlquileres")
public class HistoricoAlquileresController {

	@Autowired
	private VIviendasService viviendaService;
	
	@Autowired
	private UsuariosService usuarioService;
	@Autowired
	private HistoricoAlquileresService hAlquilerService;
	@Autowired
	private AlquilerService alquilerService;
	
	@GetMapping("/todos")
	public List<HistoricoAlquileres> findAll(){
		return hAlquilerService.findall();
	}
	
	@GetMapping("/porId/{idHistoricoAlquiler}")
	public HistoricoAlquileres findById(@PathVariable int idHistoricoAlquiler) {
		return hAlquilerService.findById(idHistoricoAlquiler);
	}
	@GetMapping("/porVivienda/{idVivienda}")
	public List<HistoricoAlquileres> findByVivienda(@PathVariable int idVivienda) {
		return hAlquilerService.findByVivienda(idVivienda);
	}
	@GetMapping("/porUsuario/{idUsuario}")
	public List<HistoricoAlquileres> findByUsuario(@PathVariable int idUsuario) {
		return hAlquilerService.findByUsuario(idUsuario);
	}
	
	@PostMapping("/insertar/{idAlquiler}")
	public int insertOne(@RequestBody HistoricoAlquileres historicoAlquiler, @PathVariable int idHistoricoAlquiler) {
		Alquileres alquiler = alquilerService.findById(idHistoricoAlquiler);
		historicoAlquiler.setAlquiler(alquiler);
		historicoAlquiler.setVivienda(alquiler.getVivienda());
		historicoAlquiler.setUsuario(alquiler.getUsuario());
		return hAlquilerService.insertOne(historicoAlquiler);
	}
	
	@DeleteMapping("/eliminar/{idHistoricoAlquiler}")
	public int deleteOne(@PathVariable int idHistoricoAlquiler) {
		return hAlquilerService.deleteOne(idHistoricoAlquiler);
	}
	
	
}
