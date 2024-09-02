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

import viviendas.modelo.entities.HistoricoSubastas;
import viviendas.modelo.entities.Pujas;
import viviendas.modelo.entities.Subastas;
import viviendas.modelo.service.HistoricoSubastasService;
import viviendas.modelo.service.SubastasService;
import viviendas.modelo.service.UsuariosService;
import viviendas.modelo.service.VIviendasService;

@RestController
@CrossOrigin( origins = "*")
@RequestMapping("/historicoSubastas")
public class HistoricoSubastasController {

	@Autowired
	private UsuariosService usuarioService;
	
	@Autowired
	private VIviendasService viviendaService;
	
	@Autowired
	private SubastasService subastaService;
	
	@Autowired
	private HistoricoSubastasService historicoSubastaService;
	
	@GetMapping("/todas")
	public List<HistoricoSubastas> findAll(){
		return historicoSubastaService.findall();
	}
	@GetMapping("/porId/{idHistoricoSubastas}")
	public HistoricoSubastas findById(@PathVariable int idHistoricoSubastas) {
		return historicoSubastaService.findById(idHistoricoSubastas);
	}
	@GetMapping("/porUsuario/{idUsuario}")
	public List<HistoricoSubastas> findByUsuario(@PathVariable int idUsuario) {
		return historicoSubastaService.findByUsuario(idUsuario);
	}
	@GetMapping("/porVivienda/{idSubasta}")
	public List<HistoricoSubastas> findByVivienda(@PathVariable int idSubasta){
		Subastas subasta = subastaService.findById(idSubasta);
		return historicoSubastaService.findByVivienda(subasta.getVivienda().getIdVivienda());
	}
	
	@PostMapping("/insertar/{idSubasta}")
	public int insertOne(@RequestBody HistoricoSubastas historicoSubasta, @PathVariable int idSubasta) {
		Subastas subasta = subastaService.findById(idSubasta);
		historicoSubasta.setSubasta(subasta);
		historicoSubasta.setVivienda(subasta.getVivienda());
		historicoSubasta.setUsuario(subasta.getUsuario());
		historicoSubasta.setFechaInicioSubasta(subasta.getFechaInicio());
		historicoSubasta.setFechaFinSubasta(subasta.getFechaFin());
		return historicoSubastaService.insertOne(historicoSubasta);
	}
	
	@DeleteMapping("/eliminar/{idHistoricoSubastas}")
	public int deleteOne(@PathVariable int idHistoricoSubastas) {
		return historicoSubastaService.deleteOne(idHistoricoSubastas);
	}
}
