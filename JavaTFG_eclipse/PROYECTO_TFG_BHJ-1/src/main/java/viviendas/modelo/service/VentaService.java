package viviendas.modelo.service;

import java.util.List;

import org.springframework.stereotype.Repository;

import viviendas.modelo.entities.Venta;
@Repository
public interface VentaService {

	int insertOne(Venta venta);
	int deleteOne(int idVenta);
	Venta findById(int idVenta);
	List<Venta> findall();
}
