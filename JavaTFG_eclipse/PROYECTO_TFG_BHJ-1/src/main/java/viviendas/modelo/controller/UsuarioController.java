package viviendas.modelo.controller;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import viviendas.modelo.entities.Usuario;
import viviendas.modelo.service.UsuarioService;
import viviendas.modelo.service.ViviendaService;


@RestController
@CrossOrigin( origins = "*")
@RequestMapping("/usuarios")
public class UsuarioController {

	@Autowired
	private UsuarioService uService;
	@Autowired
	private ViviendaService vService;
	
	@PostMapping("/login")
	public Usuario login(@RequestBody Usuario usuario) {
		Usuario usu = uService.findByUsernameAndPassword(usuario.getUsername(), usuario.getContraseña());
		if (usu != null) {
			usu.setContraseña(null);
			return usu;
		}
		return null;
	}
	
	//logout
	
	@PostMapping("/registro")
	public int registro(@RequestBody Usuario usuario) {
		return uService.insertOne(usuario);
	}
	
	@GetMapping("/porUsername/{username}")
	public Usuario findByusername(@PathVariable String username) {
		return uService.findByUsername(username);
	}
	
	
	
}
