package viviendas.modelo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import viviendas.modelo.entities.Usuarios;
import viviendas.modelo.service.UsuariosService;

@RestController
@CrossOrigin( origins = "*")
@RequestMapping("/usuarios")
public class UsuariosController {

	@Autowired
	private UsuariosService uService;
	
	@PostMapping("/login")
	public Usuarios login(@RequestBody Usuarios usuario) {
		Usuarios usu = uService.findByUsernameAndPassword(usuario.getUsername(), usuario.getPassword());
		if (usu != null) {
			usu.setPassword(null);
			return usu;
		}
		return null;
	}
	
	@PostMapping("/registro")
	public int registro(@RequestBody Usuarios usuario) {
		return uService.insertOne(usuario);
	}
	
	@GetMapping("/porIdUsuario/{idUsuario}")
	public Usuarios findByusername(@PathVariable int idUsuario) {
		return uService.findById(idUsuario);
	}
}
