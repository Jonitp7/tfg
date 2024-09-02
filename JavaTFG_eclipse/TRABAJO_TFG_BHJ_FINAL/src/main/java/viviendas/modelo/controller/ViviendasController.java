package viviendas.modelo.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import jakarta.persistence.criteria.Predicate;
import viviendas.modelo.entities.Usuarios;
import viviendas.modelo.entities.Viviendas;
import viviendas.modelo.repository.ViviendasRepository;
import viviendas.modelo.service.UsuariosService;
import viviendas.modelo.service.VIviendasService;
import viviendas.modelo.service.ViviendasServiceImpl;

@RestController
@CrossOrigin( origins = "*")
@RequestMapping("/viviendas")
public class ViviendasController {

	@Autowired
	private UsuariosService uService;
	@Autowired
	private VIviendasService vService;
	 @Autowired
	    private ViviendasRepository viviendasRepository;
	
	@GetMapping("/todas")
	public List<Viviendas> findAll(){
		return vService.findAll();
	}
	
	@GetMapping("/una/{idVivienda}")
	public Viviendas findById(@PathVariable int idVivienda){
		return vService.findById(idVivienda);
	}
	
	@GetMapping("/porUsuario/{idUsuario}")
	public List<Viviendas> findByUsuario(@PathVariable int idUsuario){
		return vService.findByUsuario(idUsuario);
	}
	
	
	@PostMapping("/insertar/{idUsuario}")
	public int insertOne(@RequestBody Viviendas viviendas, @PathVariable int idUsuario) {
		viviendas.setUsuario(uService.findById(idUsuario));
		return vService.insertOne(viviendas);
	}
	
	
	 @GetMapping("/filtro")
	 public List<Viviendas> getViviendas(@RequestParam(required = false) Integer extension,
             @RequestParam(required = false) String ubicacion,
             @RequestParam(required = false) Integer aseos,
             @RequestParam(required = false) Integer habitaciones,
             @RequestParam(required = false) Boolean garaje,
             @RequestParam(required = false) Boolean golf,
             @RequestParam(required = false) Boolean jardin,
             @RequestParam(required = false) Boolean piscina,
             @RequestParam(required = false) Boolean spa,
             @RequestParam(required = false) String descripcion,
             @RequestParam(required = false) Integer plantas,
             @RequestParam(required = false) Integer fechaConstruccion) {
			Specification<Viviendas> spec = (root, query, criteriaBuilder) -> {
			List<Predicate> predicates = new ArrayList<>();
			
			if (extension != null) {
			predicates.add(criteriaBuilder.equal(root.get("extension"), extension));
			}
			if (ubicacion != null) {
			predicates.add(criteriaBuilder.equal(root.get("ubicacion"), ubicacion));
			}
			if (aseos != null) {
			predicates.add(criteriaBuilder.equal(root.get("aseos"), aseos));
			}
			if (habitaciones != null) {
			predicates.add(criteriaBuilder.equal(root.get("habitaciones"), habitaciones));
			}
			if (garaje != null) {
			predicates.add(criteriaBuilder.equal(root.get("garaje"), garaje));
			}
			if (golf != null) {
				predicates.add(criteriaBuilder.equal(root.get("golf"), golf));
			}
			if (jardin != null) {
				predicates.add(criteriaBuilder.equal(root.get("jardin"), jardin));
			}
			if (piscina != null) {
				predicates.add(criteriaBuilder.equal(root.get("piscina"), piscina));
			}
			if (spa != null) {
				predicates.add(criteriaBuilder.equal(root.get("spa"), spa));
			}
			if (descripcion != null && !descripcion.isEmpty()) {
			predicates.add(criteriaBuilder.like(root.get("descripcion"), "%" + descripcion + "%"));
			}
			if (plantas != null) {
			predicates.add(criteriaBuilder.equal(root.get("plantas"), plantas));
			}
			if (fechaConstruccion != null) {
			predicates.add(criteriaBuilder.equal(root.get("fechaConstruccion"), fechaConstruccion));
			}
			
			return criteriaBuilder.and(predicates.toArray(new Predicate[0]));
			};
			
			return viviendasRepository.findAll(spec);
			}
			}
