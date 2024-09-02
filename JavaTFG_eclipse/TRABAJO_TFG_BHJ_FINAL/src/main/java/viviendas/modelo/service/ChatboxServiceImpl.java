package viviendas.modelo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import viviendas.modelo.entities.Chatbox;
import viviendas.modelo.repository.ChatboxRepository;
@Repository
public class ChatboxServiceImpl implements ChatboxService{
	
	@Autowired
	private ChatboxRepository chatboxRepository;

	@Override
	public int insertOne(Chatbox chatbox) {
		// TODO Auto-generated method stub
		try {
			chatboxRepository.save(chatbox);
			return 1;
		} catch (Exception e) {
			// TODO: handle exception
			return 0;
		}
	}

	@Override
	public int deleteOne(int idChat) {
		// TODO Auto-generated method stub
		try {
			chatboxRepository.deleteById(idChat);
			return 1;
		} catch (Exception e) {
			// TODO: handle exception
			return 0;
		}
	}

	@Override
	public Chatbox findById(int idChat) {
		// TODO Auto-generated method stub
		return chatboxRepository.findById(idChat).orElse(null);
	}

	@Override
	public List<Chatbox> findall() {
		// TODO Auto-generated method stub
		return chatboxRepository.findAll();
	}

	@Override
	public List<Chatbox> findByUsuario(int idUsuario) {
		// TODO Auto-generated method stub
		return chatboxRepository.findByUsuario(idUsuario);
	}

}
