package viviendas.modelo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import viviendas.modelo.entities.Comprador;
import viviendas.modelo.repository.CompradorRepository;

@Repository
public class CompradorServiceImplMy8 implements CompradorService{
	
	@Autowired
	private CompradorRepository compradorRepository;

	@Override
	public int insertOne(Comprador comprador) {
		try {
			compradorRepository.save(comprador);
			return 1;
			
		} catch (Exception e) {
			// TODO: handle exception
			return 0;
		}
	}


	@Override
	public Comprador findById(int idComprador) {
		// TODO Auto-generated method stub
		return compradorRepository.findById(idComprador).orElse(null);
	}

	@Override
	public List<Comprador> findall() {
		// TODO Auto-generated method stub
		return compradorRepository.findAll();
	}

}
