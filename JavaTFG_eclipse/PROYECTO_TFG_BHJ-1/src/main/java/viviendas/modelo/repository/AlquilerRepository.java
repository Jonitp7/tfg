package viviendas.modelo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import viviendas.modelo.entities.Alquiler;
@Repository
public interface AlquilerRepository extends JpaRepository<Alquiler, Integer>{

}
