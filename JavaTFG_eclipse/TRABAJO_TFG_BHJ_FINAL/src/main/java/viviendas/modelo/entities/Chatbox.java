package viviendas.modelo.entities;

import java.io.Serializable;
import jakarta.persistence.*;


/**
 * The persistent class for the chatbox database table.
 * 
 */
@Entity
@NamedQuery(name="Chatbox.findAll", query="SELECT c FROM Chatbox c")
public class Chatbox implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="id_chat")
	private int idChat;

	private String consulta;

	//bi-directional many-to-one association to Usuarios
	@ManyToOne
	@JoinColumn(name="id_usuario")
	private Usuarios usuario;
	
	@ManyToOne
	@JoinColumn(name="usuario_receptor")
	private Usuarios usuarioReceptor;

	public Chatbox() {
	}

	public int getIdChat() {
		return this.idChat;
	}

	public void setIdChat(int idChat) {
		this.idChat = idChat;
	}

	public String getConsulta() {
		return this.consulta;
	}

	public void setConsulta(String consulta) {
		this.consulta = consulta;
	}

	public Usuarios getUsuario() {
		return this.usuario;
	}

	public void setUsuario(Usuarios usuario) {
		this.usuario = usuario;
	}
	public Usuarios getUsuarioReceptor() {
		return this.usuarioReceptor;
	}
	
	public void setUsuarioReceptor(Usuarios usuarioReceptor) {
		this.usuarioReceptor = usuarioReceptor;
	}

}