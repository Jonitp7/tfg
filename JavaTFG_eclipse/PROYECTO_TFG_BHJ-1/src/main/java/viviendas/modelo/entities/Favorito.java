package viviendas.modelo.entities;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;


/**
 * The persistent class for the lineas_pedido database table.
 * 
 */
@AllArgsConstructor
@Builder
@Data
@Entity
@Table(name="favoritos")
public class Favorito implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_favorito")
	private int idFavorito;

	//uni-directional many-to-one association to Libro
	@ManyToOne
	@JoinColumn(name="username")
	private Usuario usuario;

	//bi-directional many-to-one association to Pedido
	@ManyToOne
	@JoinColumn(name="ID_VIVIENDA")
	private Vivienda vivienda;

	public Favorito() {
	}

	public int getIdFavorito() {
		return idFavorito;
	}

	public void setIdFavorito(int idFavorito) {
		this.idFavorito = idFavorito;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public Vivienda getVivienda() {
		return vivienda;
	}

	public void setVivienda(Vivienda vivienda) {
		this.vivienda = vivienda;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + idFavorito;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!(obj instanceof Favorito))
			return false;
		Favorito other = (Favorito) obj;
		if (idFavorito != other.idFavorito)
			return false;
		return true;
	}

	

}