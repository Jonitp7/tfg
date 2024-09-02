package viviendas.modelo.controller;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import viviendas.modelo.entities.Propietario;
import viviendas.modelo.entities.Usuario;
import viviendas.modelo.service.AlquilerService;
import viviendas.modelo.service.PropietarioService;
import viviendas.modelo.service.UsuarioService;
import viviendas.modelo.service.ViviendaService;


@RestController
@CrossOrigin( origins = "*")
@RequestMapping("/propietario")
public class PropietarioController {

	@Autowired
	private UsuarioService uService;
	@Autowired
	private ViviendaService vService;
	@Autowired
	private PropietarioService pService;
	
	
	
	@PostMapping("/registro/{username}")
	public int insertOne(@RequestBody Propietario propietario, @PathVariable String username) {
		propietario.setUsuario(uService.findByUsername(username));
		return pService.insertOne(propietario);
	}
	
	@GetMapping("/todos")
	public List<Propietario> findAll(){
		return pService.findAll();
	}
	
	
	@GetMapping("/uno/{idPropietario}")
	public Propietario findById(@PathVariable int idPropietario){
		return pService.findById(idPropietario);
	}
	
	
	
	//CRUD
	//Por precio 
	//Por estado
	
	
	
}
