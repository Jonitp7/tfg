package viviendas.modelo.controller;

import java.util.Date;
import java.util.List;

import org.hibernate.annotations.ValueGenerationType;
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

import viviendas.modelo.entities.Puja;
import viviendas.modelo.entities.Usuario;
import viviendas.modelo.service.PujaService;
import viviendas.modelo.service.SubastaService;
import viviendas.modelo.service.UsuarioService;
import viviendas.modelo.service.ViviendaService;


@RestController
@CrossOrigin( origins = "*")
@RequestMapping("/puja")
public class PujaController {

	@Autowired
	private UsuarioService uService;
	@Autowired
	private ViviendaService vService;
	@Autowired
	private SubastaService sService;
	@Autowired
	private PujaService pService;
	
	@GetMapping("/todas")
	public List<Puja> findAll(){
		return pService.findAll();
	}
	
	@PostMapping("/alta")
	public int insertOne(@RequestBody Puja puja, @RequestParam int idSubasta) {
		puja.setSubasta(sService.findById(idSubasta));
		return pService.insertOne(puja);
		
	}
	
	@DeleteMapping("/eliminar/{idPuja}")
	public int deleteOne(@PathVariable int idPuja) {
		return pService.deleteOne(idPuja);
	}
	
	@GetMapping("/buscarUna/{idPuja}")
	public Puja findById(@PathVariable int idPuja) {
		return pService.findById(idPuja);
	}
	
	@GetMapping("/porSubasta/{idSubasta}")
	public List<Puja> findBySubasta(@PathVariable int idSubasta){
		return pService.findBySubasta(idSubasta);
	}
	
	@GetMapping("/porPostor/{idPostor}")
	public List<Puja> findByPostor(@PathVariable int idPostor){
		return pService.findByComprador(idPostor);
	}
	
	//CRUD
	//Por precio 
	//Por estado
	
	
	
}
