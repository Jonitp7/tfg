package viviendas.modelo.service;

import java.util.List;

import org.springframework.stereotype.Repository;

import viviendas.modelo.entities.Comprador;
@Repository
public interface CompradorService {

	int insertOne(Comprador comprador);
	Comprador findById(int idComprador);
	List<Comprador> findall();
}
