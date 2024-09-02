package viviendas.modelo.entities;

import java.io.Serializable;
import jakarta.persistence.*;


/**
 * The persistent class for the favoritos database table.
 * 
 */
@Entity
@NamedQuery(name="Favoritos.findAll", query="SELECT f FROM Favoritos f")
public class Favoritos implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="id_favorito")
	private int idFavorito;

	//bi-directional many-to-one association to Usuarios
	@ManyToOne
	@JoinColumn(name="id_usuario")
	private Usuarios usuario;

	//bi-directional many-to-one association to Viviendas
	@ManyToOne
	@JoinColumn(name="id_vivienda")
	private Viviendas vivienda;

	public Favoritos() {
	}

	public int getIdFavorito() {
		return this.idFavorito;
	}

	public void setIdFavorito(int idFavorito) {
		this.idFavorito = idFavorito;
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