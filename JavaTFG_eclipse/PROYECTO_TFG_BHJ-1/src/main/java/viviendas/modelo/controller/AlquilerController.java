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
import viviendas.modelo.service.AlquilerService;
import viviendas.modelo.service.UsuarioService;
import viviendas.modelo.service.ViviendaService;


@RestController
@CrossOrigin( origins = "*")
@RequestMapping("/alquiler")
public class AlquilerController {

	@Autowired
	private UsuarioService uService;
	@Autowired
	private ViviendaService vService;
	@Autowired
	private AlquilerService aService;
	
	
	
	
	//CRUD
	//Por precio 
	//Por estado
	
	
	
}
