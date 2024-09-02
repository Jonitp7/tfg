package viviendas.modelo.entities;

import java.io.Serializable;
import jakarta.persistence.*;
import java.util.List;


/**
 * The persistent class for the propietarios database table.
 * 
 */
@Entity
@Table(name="propietarios")
@NamedQuery(name="Propietario.findAll", query="SELECT p FROM Propietario p")
public class Propietario implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="id_propietario")
	private int idPropietario;

	@Column(name="tipo_propietario")
	private byte tipoPropietario;

	//bi-directional many-to-one association to Usuario
	@ManyToOne
	@JoinColumn(name="username")
	private Usuario usuario;

	//bi-directional many-to-one association to Vivienda
	@OneToMany(mappedBy="propietario")
	private List<Vivienda> viviendas;

	public Propietario() {
	}

	public int getIdPropietario() {
		return this.idPropietario;
	}

	public void setIdPropietario(int idPropietario) {
		this.idPropietario = idPropietario;
	}

	public byte getTipoPropietario() {
		return this.tipoPropietario;
	}

	public void setTipoPropietario(byte tipoPropietario) {
		this.tipoPropietario = tipoPropietario;
	}

	public Usuario getUsuario() {
		return this.usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public List<Vivienda> getViviendas() {
		return this.viviendas;
	}

	public void setViviendas(List<Vivienda> viviendas) {
		this.viviendas = viviendas;
	}

	public Vivienda addVivienda(Vivienda vivienda) {
		getViviendas().add(vivienda);
		vivienda.setPropietario(this);

		return vivienda;
	}

	public Vivienda removeVivienda(Vivienda vivienda) {
		getViviendas().remove(vivienda);
		vivienda.setPropietario(null);

		return vivienda;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + idPropietario;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!(obj instanceof Propietario))
			return false;
		Propietario other = (Propietario) obj;
		if (idPropietario != other.idPropietario)
			return false;
		return true;
	}

}