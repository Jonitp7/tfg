package viviendas.modelo.service;

import java.util.List;

import org.springframework.stereotype.Repository;

import viviendas.modelo.entities.Chatbox;
import viviendas.modelo.entities.Viviendas;

@Repository
public interface ChatboxService {

	int insertOne(Chatbox chatbox);
	int deleteOne(int idChat);
	Chatbox findById(int idChat);
	List<Chatbox> findall();
	List<Chatbox> findByUsuario(int idUsuario);
}
