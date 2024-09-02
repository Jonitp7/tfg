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

import viviendas.modelo.entities.Pujas;
import viviendas.modelo.entities.Subastas;
import viviendas.modelo.service.PujasService;
import viviendas.modelo.service.SubastasService;
import viviendas.modelo.service.UsuariosService;
import viviendas.modelo.service.VIviendasService;

@RestController
@CrossOrigin( origins = "*")
@RequestMapping("/pujas")
public class PujasController {

	@Autowired
	private UsuariosService usuarioService;
	
	@Autowired
	private VIviendasService viviendaService;
	
	@Autowired
	private SubastasService subastaService;
	
	@Autowired
	private PujasService pujaService;
	
	@GetMapping("/todas")
	public List<Pujas> findAll(){
		return pujaService.findAll();
	}
	@GetMapping("/porId/{idPuja}")
	public Pujas findById(@PathVariable int idPuja) {
		return pujaService.findById(idPuja);
	}
	@GetMapping("/porUsuario/{idUsuario}")
	public List<Pujas> findByUsuario(@PathVariable int idUsuario) {
		return pujaService.findByUsuario(idUsuario);
	}
	@GetMapping("/porVivienda/{idSubasta}")
	public List<Pujas> findByVivienda(@PathVariable int idSubasta){
		Subastas subasta = subastaService.findById(idSubasta);
		return pujaService.findByVivienda(subasta.getVivienda().getIdVivienda());
	}
	
	@PostMapping("/insertar/{idSubasta}/{idUsuario}")
	public int insertOne(@RequestBody Pujas puja, @PathVariable int idSubasta, @PathVariable int idUsuario) {
		puja.setSubasta(subastaService.findById(idSubasta));
		puja.setUsuario(usuarioService.findById(idUsuario));
		return pujaService.insertOne(puja);
	}
	
	@DeleteMapping("/eliminar/{idPuja}")
	public int deleteOne(@PathVariable int idPuja) {
		return pujaService.deleteOne(idPuja);
	}
}
