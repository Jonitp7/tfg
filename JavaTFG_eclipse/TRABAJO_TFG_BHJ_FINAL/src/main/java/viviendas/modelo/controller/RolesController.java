package viviendas.modelo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import viviendas.modelo.entities.Roles;
import viviendas.modelo.service.RolesService;
import viviendas.modelo.service.UsuariosService;

@RestController
@CrossOrigin( origins = "*")
@RequestMapping("/roles")
public class RolesController {

	@Autowired
	private RolesService rolService;
	
	@Autowired
	private UsuariosService usuarioService;
	
	@PostMapping("/asignar/{idUsuario}")
	public int insertOne(@RequestBody Roles rol,@PathVariable int idUsuario) {
		rol.setUsuario(usuarioService.findById(idUsuario));
		return rolService.insertOne(rol);
	}
	
	@GetMapping("/todos")
	public List<Roles> findAll(){
		return rolService.findall();
	}
	
	@GetMapping("/porUsuario/{idUsuario}")
	public List<Roles> findByUsuario(@PathVariable int idUsuario){
		return rolService.findByUsuario(idUsuario);
	}
 	
	
	
}
