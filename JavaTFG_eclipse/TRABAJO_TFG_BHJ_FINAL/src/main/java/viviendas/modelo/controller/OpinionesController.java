package viviendas.modelo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import viviendas.modelo.entities.Opiniones;
import viviendas.modelo.entities.Viviendas;
import viviendas.modelo.service.OpinionesService;
import viviendas.modelo.service.UsuariosService;
import viviendas.modelo.service.VIviendasService;

@RestController
@CrossOrigin( origins = "*")
@RequestMapping("/opiniones")
public class OpinionesController {

	@Autowired
	private VIviendasService viviendaService;
	
	@Autowired
	private UsuariosService usuarioService;
	
	@Autowired
	private OpinionesService opinionService;
	
	
	@GetMapping("/todas")
	public List<Opiniones> findAll(){
		return opinionService.findall();
				
	}
	
	@GetMapping("/porId/{idOpinion}")
	public Opiniones findById(@PathVariable int idOpinion) {
		return opinionService.findById(idOpinion);
	}
	
	@GetMapping("/porUsuario/{idUsuario}")
	public List<Opiniones> findByusuario(@PathVariable int idUsuario) {
		return opinionService.findByUsuario(idUsuario);
	}
	
	@GetMapping("/porVivienda/{idVivienda}")
	public List<Opiniones> findByVivienda(@PathVariable int idVivienda) {
		return opinionService.findByVivienda(idVivienda);
	}
	
	@PostMapping("/insertar/{idUsuario}/{idVivienda}")
	public int insertOne(@RequestBody Opiniones opinion, @PathVariable int idUsuario, @PathVariable int idVivienda) {
		opinion.setUsuario(usuarioService.findById(idUsuario));
		opinion.setVivienda(viviendaService.findById(idVivienda));
		return opinionService.insertOne(opinion);
	}
	
	@DeleteMapping("/eliminar/{idOpinion}")
	public int deleteOne(@PathVariable int idOpinion) {
		return opinionService.deleteOne(idOpinion);
	}
	
	
	@PutMapping("/actualizar/{idVivienda}")
	public int updateVivienda(@PathVariable int idVivienda) {
		int valoracion = opinionService.sumValoraciones(idVivienda);
		int filas = opinionService.countFilas(idVivienda);
		
		int valoracionFinal = valoracion/filas;
		Viviendas vivienda = viviendaService.findById(idVivienda);
		vivienda.setValoracion(valoracionFinal);
		return viviendaService.updateOne(vivienda);
	}
	
}
