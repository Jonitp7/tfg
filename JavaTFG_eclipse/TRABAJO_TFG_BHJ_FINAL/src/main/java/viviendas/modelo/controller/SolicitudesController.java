package viviendas.modelo.controller;



import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import viviendas.modelo.entities.DatosVivienda;
import viviendas.modelo.entities.Solicitudes;
import viviendas.modelo.repository.SolicitudesRepository;
import viviendas.modelo.service.SolicitudesService;
import viviendas.modelo.service.UsuariosService;

@RestController
@CrossOrigin( origins = "*")
@RequestMapping("/solicitudes")
public class SolicitudesController {
	
	@Autowired
	private SolicitudesService solicitudService;
	
	@Autowired
	private SolicitudesRepository solicitudRepository;
	
	@Autowired
	private UsuariosService usuariosService;
	
	@PostMapping("/insertar/{idUsuario}")
	public int insertOne(@RequestBody DatosVivienda datosVivienda, @PathVariable int idUsuario) {
		Solicitudes solicitud = new Solicitudes();
		solicitud.setEstadoSolicitud("En proceso");
		solicitud.setFecha(new Date());
		solicitud.setDatosVivienda(datosVivienda);
		solicitud.setUsuario(usuariosService.findById(idUsuario));
		
		return solicitudService.insertOne(solicitud);
	}
	
	@PutMapping("/aceptar/{idSolicitud}")
	public int updateOne(@PathVariable int idSolicitud) {
		Solicitudes solicitud = solicitudService.findById(idSolicitud);
		solicitud.setEstadoSolicitud("Aceptada"); 
		return solicitudService.updateOne(solicitud);
	}
	
	@DeleteMapping("/rechazar/{idSolicitud}")
	public int deleteOne(@PathVariable int idSolicitud) {
		return solicitudService.deleteOne(idSolicitud);
	}
	
	@GetMapping("/porUsuario/{idUsuario}")
	public List<Solicitudes> porUsuario(@PathVariable int idUsuario){
		return solicitudService.findByIdUsuario(idUsuario);
	}
	
	@GetMapping("/todas")
	public List<Solicitudes> findAll(){
		return solicitudService.findall();
	}
	
	@GetMapping("/porId/{idSolicitud}")
	public Solicitudes findById(@PathVariable int idSolicitud){
		return solicitudService.findById(idSolicitud);
	}

}
