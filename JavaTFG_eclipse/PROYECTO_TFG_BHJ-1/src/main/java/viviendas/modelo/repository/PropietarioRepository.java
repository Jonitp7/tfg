package viviendas.modelo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import viviendas.modelo.entities.Propietario;
@Repository
public interface PropietarioRepository extends JpaRepository<Propietario, Integer>{

}
