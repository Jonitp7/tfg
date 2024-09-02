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

import viviendas.modelo.entities.Chatbox;
import viviendas.modelo.service.ChatboxService;
import viviendas.modelo.service.UsuariosService;

@RestController
@CrossOrigin( origins = "*")
@RequestMapping("/chatBox")
public class ChatBoxController {

	@Autowired
	private UsuariosService usuarioService;
	
	@Autowired
	private ChatboxService chatBoxService;
	
	@GetMapping("/todos")
	public List<Chatbox> findAll(){
		return chatBoxService.findall();
				
	}
	
	@GetMapping("/porId/{idChat}")
	public Chatbox findById(@PathVariable int idChat) {
		return chatBoxService.findById(idChat);
	}
	
	@GetMapping("/porUsuario/{idUsuario}")
	public List<Chatbox> findByUsuario(@PathVariable int idUsuario) {
		return chatBoxService.findByUsuario(idUsuario);
	}
	
	@PostMapping("/insertar/{idUsuario}")
	public int insertOne(@RequestBody Chatbox chatBox, @PathVariable int idUsuario) {
		chatBox.setUsuario(usuarioService.findById(idUsuario));
		return chatBoxService.insertOne(chatBox);
	}
	
	@DeleteMapping("/eliminar/{idChat}")
	public int deleteOne(@PathVariable int idChat) {
		return chatBoxService.deleteOne(idChat);
	}
}
