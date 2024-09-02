package viviendas.modelo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import viviendas.modelo.entities.ChatsProp;
import viviendas.modelo.repository.ChatsPropRepository;
@Repository
public class ChatsPropServiceImpl implements ChatsPropService{
	
	@Autowired
	private ChatsPropRepository chatpropRepository;

	@Override
	public int insertOne(ChatsProp chatprop) {
		// TODO Auto-generated method stub
		try {
			chatpropRepository.save(chatprop);
			return 1;
		} catch (Exception e) {
			// TODO: handle exception
			return 0;
		}
	}

	@Override
	public int deleteOne(int idChatProp) {
		// TODO Auto-generated method stub
		try {
			chatpropRepository.deleteById(idChatProp);
			return 1;
		} catch (Exception e) {
			// TODO: handle exception
			return 0;
		}
	}

	@Override
	public ChatsProp findById(int idChatProp) {
		// TODO Auto-generated method stub
		return chatpropRepository.findById(idChatProp).orElse(null);
	}

	@Override
	public List<ChatsProp> findall() {
		// TODO Auto-generated method stub
		return chatpropRepository.findAll();
	}

}
