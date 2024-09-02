package viviendas.modelo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import viviendas.modelo.entities.Venta;
import viviendas.modelo.repository.VentaRepository;

@Repository
public class VentaServiceImplMy8 implements VentaService{
	
	@Autowired
	private VentaRepository ventaRepository;

	@Override
	public int insertOne(Venta venta) {
		try {
			ventaRepository.save(venta);
			return 1;
		} catch (Exception e) {
			// TODO: handle exception
			return 0;
		}
	}

	@Override
	public int deleteOne(int idVenta) {
		try {
			ventaRepository.deleteById(idVenta);
			return 1;
		} catch (Exception e) {
			// TODO: handle exception
			return 0;
		}
	}

	@Override
	public Venta findById(int idVenta) {
		// TODO Auto-generated method stub
		return ventaRepository.findById(idVenta).orElse(null);
	}

	@Override
	public List<Venta> findall() {
		// TODO Auto-generated method stub
		return ventaRepository.findAll();
	}

}
