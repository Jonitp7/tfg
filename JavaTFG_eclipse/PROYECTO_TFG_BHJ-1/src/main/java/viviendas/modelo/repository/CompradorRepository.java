package viviendas.modelo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import viviendas.modelo.entities.Comprador;
@Repository
public interface CompradorRepository extends JpaRepository<Comprador, Integer>{

}
