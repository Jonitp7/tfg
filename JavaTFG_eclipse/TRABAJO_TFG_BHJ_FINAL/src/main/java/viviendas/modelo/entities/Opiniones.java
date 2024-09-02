package viviendas.modelo.entities;

import java.io.Serializable;
import jakarta.persistence.*;
import java.util.Date;


/**
 * The persistent class for the opiniones database table.
 * 
 */
@Entity
@NamedQuery(name="Opiniones.findAll", query="SELECT o FROM Opiniones o")
public class Opiniones implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="id_opinion")
	private int idOpinion;

	private String comentario;

	@Temporal(TemporalType.DATE)
	@Column(name="fecha_opinion")
	private Date fechaOpinion;

	private int valoracion;

	//bi-directional many-to-one association to Usuarios
	@ManyToOne
	@JoinColumn(name="id_usuario")
	private Usuarios usuario;

	//bi-directional many-to-one association to Viviendas
	@ManyToOne
	@JoinColumn(name="id_vivienda")
	private Viviendas vivienda;

	public Opiniones() {
	}

	public int getIdOpinion() {
		return this.idOpinion;
	}

	public void setIdOpinion(int idOpinion) {
		this.idOpinion = idOpinion;
	}

	public String getComentario() {
		return this.comentario;
	}

	public void setComentario(String comentario) {
		this.comentario = comentario;
	}

	public Date getFechaOpinion() {
		return this.fechaOpinion;
	}

	public void setFechaOpinion(Date fechaOpinion) {
		this.fechaOpinion = fechaOpinion;
	}

	public int getValoracion() {
		return this.valoracion;
	}

	public void setValoracion(int valoracion) {
		this.valoracion = valoracion;
	}

	public Usuarios getUsuario() {
		return this.usuario;
	}

	public void setUsuario(Usuarios usuario) {
		this.usuario = usuario;
	}

	public Viviendas getVivienda() {
		return this.vivienda;
	}

	public void setVivienda(Viviendas vivienda) {
		this.vivienda = vivienda;
	}

}