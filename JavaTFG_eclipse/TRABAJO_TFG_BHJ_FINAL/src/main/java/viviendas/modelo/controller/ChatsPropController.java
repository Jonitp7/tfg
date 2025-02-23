package viviendas.modelo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import viviendas.modelo.entities.ChatsProp;
import viviendas.modelo.service.ChatsPropService;
import viviendas.modelo.service.UsuariosService;

@RestController
@CrossOrigin( origins = "*")
@RequestMapping("/chatProps")
public class ChatsPropController {

	@Autowired
	private UsuariosService usuarioService;
	
	@Autowired
	private ChatsPropService chatPropService;
	
	@GetMapping("/todos")
	public List<ChatsProp> findall(){
		return chatPropService.findall();
	}
	@GetMapping("/porId/{idChatProp}")
	public ChatsProp findById(@PathVariable int idhatProp) {
		return chatPropService.findById(idhatProp);
	}
}
