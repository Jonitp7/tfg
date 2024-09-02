package viviendas.modelo.entities;

import java.io.Serializable;
import jakarta.persistence.*;


/**
 * The persistent class for the pujas database table.
 * 
 */
@Entity
@NamedQuery(name="Pujas.findAll", query="SELECT p FROM Pujas p")
public class Pujas implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="id_puja")
	private int idPuja;

	@Column(name="estado_puja")
	private String estadoPuja;

	@Column(name="valor_puja")
	private int valorPuja;

	//bi-directional many-to-one association to Subastas
	@ManyToOne
	@JoinColumn(name="id_subasta")
	private Subastas subasta;

	//bi-directional many-to-one association to Usuarios
	@ManyToOne
	@JoinColumn(name="id_usuario")
	private Usuarios usuario;

	public Pujas() {
	}

	public int getIdPuja() {
		return this.idPuja;
	}

	public void setIdPuja(int idPuja) {
		this.idPuja = idPuja;
	}

	public String getEstadoPuja() {
		return this.estadoPuja;
	}

	public void setEstadoPuja(String estadoPuja) {
		this.estadoPuja = estadoPuja;
	}

	public int getValorPuja() {
		return this.valorPuja;
	}

	public void setValorPuja(int valorPuja) {
		this.valorPuja = valorPuja;
	}

	public Subastas getSubasta() {
		return this.subasta;
	}

	public void setSubasta(Subastas subasta) {
		this.subasta = subasta;
	}

	public Usuarios getUsuario() {
		return this.usuario;
	}

	public void setUsuario(Usuarios usuario) {
		this.usuario = usuario;
	}

}