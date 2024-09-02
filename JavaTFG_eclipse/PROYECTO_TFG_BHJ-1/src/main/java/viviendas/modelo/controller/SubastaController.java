package viviendas.modelo.controller;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import viviendas.modelo.entities.Subasta;
import viviendas.modelo.entities.Usuario;
import viviendas.modelo.service.SubastaService;
import viviendas.modelo.service.UsuarioService;
import viviendas.modelo.service.ViviendaService;


@RestController
@CrossOrigin( origins = "*")
@RequestMapping("/subasta")
public class SubastaController {

	@Autowired
	private UsuarioService uService;
	@Autowired
	private ViviendaService vService;
	@Autowired
	private SubastaService sService;
	
	
	@PostMapping("/alta")
	public int altaSubasta(@RequestBody Subasta subasta, @RequestParam int idVivienda) {
		subasta.setVivienda(vService.findById(idVivienda));
		return sService.insertOne(subasta);
	}
	
	@GetMapping("/todas")
	public List<Subasta> buscarTodas(){
		return sService.findAll();
	}
	
	@DeleteMapping("/eliminar/{idSubasta}")
	public int eliminarSubasta(@PathVariable int idSubasta) {
		return sService.deleteOne(idSubasta);
	}
	
	@GetMapping("/porFechaInicio")
	public List<Subasta> porFechaInicio(@PathVariable Date fechaInicio){
		return sService.findbyFechaInicio(fechaInicio);
	}
	@GetMapping("/porFechaFin")
	public List<Subasta> porFechaFin(@PathVariable Date fechaFin){
		return sService.findbyFechaInicio(fechaFin);
	}
	
	//CRUD
	//Por precio 
	//Por estado
	
	
	
}
