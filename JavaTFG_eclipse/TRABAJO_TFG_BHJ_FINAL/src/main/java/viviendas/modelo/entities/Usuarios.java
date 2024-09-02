package viviendas.modelo.entities;

import java.io.Serializable;
import jakarta.persistence.*;
import java.util.Date;
import java.sql.Timestamp;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;


/**
 * The persistent class for the usuarios database table.
 * 
 */
@Entity
@NamedQuery(name="Usuarios.findAll", query="SELECT u FROM Usuarios u")
public class Usuarios implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="id_usuario")
	private int idUsuario;

	private String apellidos;

	private String dni;

	private String email;

	@Column(name="fecha_alta")
	private Timestamp fechaAlta;


	@Temporal(TemporalType.DATE)
	@Column(name="fecha_nacimiento")
	private Date fechaNacimiento;

	private String nombre;

	@Column(name="numero_telefono")
	private String numeroTelefono;

	private String password;

	@Column(name="tipo_usuario")
	private String tipoUsuario;

	private String username;

	//bi-directional many-to-one association to Alquileres
	@OneToMany(mappedBy="usuario")
	@JsonIgnore
	private List<Alquileres> alquileres;

	//bi-directional many-to-one association to Chatbox
	@OneToMany(mappedBy="usuario")
	@JsonIgnore
	private List<Chatbox> chatboxs;

	//bi-directional many-to-one association to ChatsProp
	@OneToMany(mappedBy="usuario")
	@JsonIgnore
	private List<ChatsProp> chatsProps;

	//bi-directional many-to-one association to Favoritos
	@OneToMany(mappedBy="usuario")
	@JsonIgnore
	private List<Favoritos> favoritos;

	//bi-directional many-to-one association to HistoricoAlquileres
	@OneToMany(mappedBy="usuario")
	@JsonIgnore
	private List<HistoricoAlquileres> historicoAlquileres;

	//bi-directional many-to-one association to HistoricoSubastas
	@OneToMany(mappedBy="usuario")
	@JsonIgnore
	private List<HistoricoSubastas> historicoSubastas;

	//bi-directional many-to-one association to Opiniones
	@OneToMany(mappedBy="usuario")
	@JsonIgnore
	private List<Opiniones> opiniones;

	//bi-directional many-to-one association to Pujas
	@OneToMany(mappedBy="usuario")
	@JsonIgnore
	private List<Pujas> pujas;

	//bi-directional many-to-one association to Roles
	@OneToMany(mappedBy="usuario")
	@JsonIgnore
	private List<Roles> roles;

	//bi-directional many-to-one association to Solicitudes
	@OneToMany(mappedBy="usuario")
	@JsonIgnore
	private List<Solicitudes> solicitudes;

	//bi-directional many-to-one association to Viviendas
	@OneToMany(mappedBy="usuario")
	@JsonIgnore
	private List<Viviendas> viviendas;

	public Usuarios() {
	}

	public int getIdUsuario() {
		return this.idUsuario;
	}

	public void setIdUsuario(int idUsuario) {
		this.idUsuario = idUsuario;
	}

	public String getApellidos() {
		return this.apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	public String getDni() {
		return this.dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	

	public Timestamp getFechaAlta() {
		return this.fechaAlta;
	}

	public void setFechaAlta(Timestamp fechaAlta) {
		this.fechaAlta = fechaAlta;
	}

	

	public Date getFechaNacimiento() {
		return this.fechaNacimiento;
	}

	public void setFechaNacimiento(Date fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getNumeroTelefono() {
		return this.numeroTelefono;
	}

	public void setNumeroTelefono(String numeroTelefono) {
		this.numeroTelefono = numeroTelefono;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getTipoUsuario() {
		return this.tipoUsuario;
	}

	public void setTipoUsuario(String tipoUsuario) {
		this.tipoUsuario = tipoUsuario;
	}

	public String getUsername() {
		return this.username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public List<Alquileres> getAlquileres() {
		return this.alquileres;
	}

	public void setAlquileres(List<Alquileres> alquileres) {
		this.alquileres = alquileres;
	}

	public Alquileres addAlquilere(Alquileres alquilere) {
		getAlquileres().add(alquilere);
		alquilere.setUsuario(this);

		return alquilere;
	}

	public Alquileres removeAlquilere(Alquileres alquilere) {
		getAlquileres().remove(alquilere);
		alquilere.setUsuario(null);

		return alquilere;
	}

	public List<Chatbox> getChatboxs() {
		return this.chatboxs;
	}

	public void setChatboxs(List<Chatbox> chatboxs) {
		this.chatboxs = chatboxs;
	}

	public Chatbox addChatbox(Chatbox chatbox) {
		getChatboxs().add(chatbox);
		chatbox.setUsuario(this);

		return chatbox;
	}

	public Chatbox removeChatbox(Chatbox chatbox) {
		getChatboxs().remove(chatbox);
		chatbox.setUsuario(null);

		return chatbox;
	}

	public List<ChatsProp> getChatsProps() {
		return this.chatsProps;
	}

	public void setChatsProps(List<ChatsProp> chatsProps) {
		this.chatsProps = chatsProps;
	}

	public ChatsProp addChatsProp(ChatsProp chatsProp) {
		getChatsProps().add(chatsProp);
		chatsProp.setUsuario(this);

		return chatsProp;
	}

	public ChatsProp removeChatsProp(ChatsProp chatsProp) {
		getChatsProps().remove(chatsProp);
		chatsProp.setUsuario(null);

		return chatsProp;
	}

	public List<Favoritos> getFavoritos() {
		return this.favoritos;
	}

	public void setFavoritos(List<Favoritos> favoritos) {
		this.favoritos = favoritos;
	}

	public Favoritos addFavorito(Favoritos favorito) {
		getFavoritos().add(favorito);
		favorito.setUsuario(this);

		return favorito;
	}

	public Favoritos removeFavorito(Favoritos favorito) {
		getFavoritos().remove(favorito);
		favorito.setUsuario(null);

		return favorito;
	}

	public List<HistoricoAlquileres> getHistoricoAlquileres() {
		return this.historicoAlquileres;
	}

	public void setHistoricoAlquileres(List<HistoricoAlquileres> historicoAlquileres) {
		this.historicoAlquileres = historicoAlquileres;
	}

	public HistoricoAlquileres addHistoricoAlquilere(HistoricoAlquileres historicoAlquilere) {
		getHistoricoAlquileres().add(historicoAlquilere);
		historicoAlquilere.setUsuario(this);

		return historicoAlquilere;
	}

	public HistoricoAlquileres removeHistoricoAlquilere(HistoricoAlquileres historicoAlquilere) {
		getHistoricoAlquileres().remove(historicoAlquilere);
		historicoAlquilere.setUsuario(null);

		return historicoAlquilere;
	}

	public List<HistoricoSubastas> getHistoricoSubastas() {
		return this.historicoSubastas;
	}

	public void setHistoricoSubastas(List<HistoricoSubastas> historicoSubastas) {
		this.historicoSubastas = historicoSubastas;
	}

	public HistoricoSubastas addHistoricoSubasta(HistoricoSubastas historicoSubasta) {
		getHistoricoSubastas().add(historicoSubasta);
		historicoSubasta.setUsuario(this);

		return historicoSubasta;
	}

	public HistoricoSubastas removeHistoricoSubasta(HistoricoSubastas historicoSubasta) {
		getHistoricoSubastas().remove(historicoSubasta);
		historicoSubasta.setUsuario(null);

		return historicoSubasta;
	}

	public List<Opiniones> getOpiniones() {
		return this.opiniones;
	}

	public void setOpiniones(List<Opiniones> opiniones) {
		this.opiniones = opiniones;
	}

	public Opiniones addOpinione(Opiniones opinione) {
		getOpiniones().add(opinione);
		opinione.setUsuario(this);

		return opinione;
	}

	public Opiniones removeOpinione(Opiniones opinione) {
		getOpiniones().remove(opinione);
		opinione.setUsuario(null);

		return opinione;
	}

	public List<Pujas> getPujas() {
		return this.pujas;
	}

	public void setPujas(List<Pujas> pujas) {
		this.pujas = pujas;
	}

	public Pujas addPuja(Pujas puja) {
		getPujas().add(puja);
		puja.setUsuario(this);

		return puja;
	}

	public Pujas removePuja(Pujas puja) {
		getPujas().remove(puja);
		puja.setUsuario(null);

		return puja;
	}

	public List<Roles> getRoles() {
		return this.roles;
	}

	public void setRoles(List<Roles> roles) {
		this.roles = roles;
	}

	public Roles addRole(Roles role) {
		getRoles().add(role);
		role.setUsuario(this);

		return role;
	}

	public Roles removeRole(Roles role) {
		getRoles().remove(role);
		role.setUsuario(null);

		return role;
	}

	public List<Solicitudes> getSolicitudes() {
		return this.solicitudes;
	}

	public void setSolicitudes(List<Solicitudes> solicitudes) {
		this.solicitudes = solicitudes;
	}

	public Solicitudes addSolicitude(Solicitudes solicitude) {
		getSolicitudes().add(solicitude);
		solicitude.setUsuario(this);

		return solicitude;
	}

	public Solicitudes removeSolicitude(Solicitudes solicitude) {
		getSolicitudes().remove(solicitude);
		solicitude.setUsuario(null);

		return solicitude;
	}

	public List<Viviendas> getViviendas() {
		return this.viviendas;
	}

	public void setViviendas(List<Viviendas> viviendas) {
		this.viviendas = viviendas;
	}

	public Viviendas addVivienda(Viviendas vivienda) {
		getViviendas().add(vivienda);
		vivienda.setUsuario(this);

		return vivienda;
	}

	public Viviendas removeVivienda(Viviendas vivienda) {
		getViviendas().remove(vivienda);
		vivienda.setUsuario(null);

		return vivienda;
	}

}