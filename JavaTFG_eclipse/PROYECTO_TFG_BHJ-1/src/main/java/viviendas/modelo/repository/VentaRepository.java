package viviendas.modelo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import viviendas.modelo.entities.Venta;
@Repository
public interface VentaRepository extends JpaRepository<Venta, Integer>{

}
