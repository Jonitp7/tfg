package viviendas.modelo.entities;

import java.io.Serializable;
import jakarta.persistence.*;
import java.util.Date;


/**
 * The persistent class for the chats_prop database table.
 * 
 */
@Entity
@Table(name="chats_prop")
@NamedQuery(name="ChatsProp.findAll", query="SELECT c FROM ChatsProp c")
public class ChatsProp implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="id_chat_prop")
	private int idChatProp;

	@Temporal(TemporalType.DATE)
	private Date fecha;

	private byte leido;

	private String mensaje;

	//bi-directional many-to-one association to Usuarios
	@ManyToOne
	@JoinColumn(name="id_usuario")
	private Usuarios usuario;
	@ManyToOne
	@JoinColumn(name="usuario_receptor")
	private Usuarios usuarioReceptor;

	public ChatsProp() {
	}

	public int getIdChatProp() {
		return this.idChatProp;
	}

	public void setIdChatProp(int idChatProp) {
		this.idChatProp = idChatProp;
	}

	public Date getFecha() {
		return this.fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public byte getLeido() {
		return this.leido;
	}

	public void setLeido(byte leido) {
		this.leido = leido;
	}

	public String getMensaje() {
		return this.mensaje;
	}

	public void setMensaje(String mensaje) {
		this.mensaje = mensaje;
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