package viviendas.modelo.entities;

import java.io.Serializable;
import jakarta.persistence.*;


/**
 * The persistent class for the pujas database table.
 * 
 */
@Entity
@Table(name="pujas")
@NamedQuery(name="Puja.findAll", query="SELECT p FROM Puja p")
public class Puja implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="id_puja")
	private int idPuja;

	private int cantidad;

	//bi-directional many-to-one association to Subasta
	@ManyToOne
	@JoinColumn(name="id_subasta")
	private Subasta subasta;

	//bi-directional many-to-one association to Compradore
	@ManyToOne
	@JoinColumn(name="id_postor")
	private Comprador comprador;

	public Puja() {
	}

	public int getIdPuja() {
		return this.idPuja;
	}

	public void setIdPuja(int idPuja) {
		this.idPuja = idPuja;
	}

	public int getCantidad() {
		return this.cantidad;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}

	public Subasta getSubasta() {
		return this.subasta;
	}

	public void setSubasta(Subasta subasta) {
		this.subasta = subasta;
	}

	public Comprador getCompradore() {
		return this.comprador;
	}

	public void setComprador(Comprador comprador) {
		this.comprador = comprador;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + idPuja;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!(obj instanceof Puja))
			return false;
		Puja other = (Puja) obj;
		if (idPuja != other.idPuja)
			return false;
		return true;
	}

}