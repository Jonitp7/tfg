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
import viviendas.modelo.service.AlquilerService;
import viviendas.modelo.service.UsuariosService;
import viviendas.modelo.service.VIviendasService;

@RestController
@CrossOrigin( origins = "*")
@RequestMapping("/alquileres")
public class AlquilerController {
	
	@Autowired
	private AlquilerService alquilerService;
	
	@Autowired
	private VIviendasService viviendaService;
	
	@Autowired
	private UsuariosService usuarioService;
	
	
	@GetMapping("/todos")
	public List<Alquileres> findAll(){
		return alquilerService.findAll();
		
	}
	
	@GetMapping("/porId/{idAlquiler}")
	public Alquileres findById(@PathVariable int idAlquiler){
		return alquilerService.findById(idAlquiler);
	}
	
	@GetMapping("/porUsuario/{idUsuario}")
	public List<Alquileres> findByUsuario(@PathVariable int idUsuario){
		return alquilerService.findByUsuario(idUsuario);
	}
	
	@GetMapping("/porVivienda/{idVivienda}")
	public List<Alquileres> findByVivienda(@PathVariable int idVivienda){
		return alquilerService.findByVivienda(idVivienda);
	}
	
	@PostMapping("/insertar/{idVivienda}/{idUsuario}")
	public int inserOne(@RequestBody Alquileres alquiler, @PathVariable int idVivienda, @PathVariable int idUsuario) {
		alquiler.setVivienda(viviendaService.findById(idVivienda));
		alquiler.setUsuario(usuarioService.findById(idUsuario));
		return alquilerService.insertOne(alquiler);
	}
	
	@DeleteMapping("/eliminar/{idAlquiler}")
	public int deleteOne(@PathVariable int idAlquiler) {
		return alquilerService.deleteOne(idAlquiler);
	}
	
	

}
