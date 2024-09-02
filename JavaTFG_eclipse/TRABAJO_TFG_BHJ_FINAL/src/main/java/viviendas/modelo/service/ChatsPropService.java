package viviendas.modelo.service;

import java.util.List;

import org.springframework.stereotype.Repository;

import viviendas.modelo.entities.ChatsProp;

@Repository
public interface ChatsPropService {

	int insertOne(ChatsProp chatprop);
	int deleteOne(int idChatProp);
	ChatsProp findById(int idChatProp);
	List<ChatsProp> findall();
}
