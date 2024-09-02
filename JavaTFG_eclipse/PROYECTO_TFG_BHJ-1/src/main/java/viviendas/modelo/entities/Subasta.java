package viviendas.modelo.entities;

import java.io.Serializable;
import jakarta.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the subastas database table.
 * 
 */
@Entity
@Table(name="subastas")
@NamedQuery(name="Subasta.findAll", query="SELECT s FROM Subasta s")
public class Subasta implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="id_subasta")
	private int idSubasta;

	private String estado;

	@Temporal(TemporalType.DATE)
	@Column(name="fecha_fin")
	private Date fechaFin;

	@Temporal(TemporalType.DATE)
	@Column(name="fecha_inicio")
	private Date fechaInicio;

	@Column(name="precio_inicial")
	private int precioInicial;

	//bi-directional many-to-one association to Puja
	@OneToMany(mappedBy="subasta")
	private List<Puja> pujas;

	//bi-directional many-to-one association to Vivienda
	@ManyToOne
	@JoinColumn(name="id_vivienda")
	private Vivienda vivienda;

	public Subasta() {
	}

	public int getIdSubasta() {
		return this.idSubasta;
	}

	public void setIdSubasta(int idSubasta) {
		this.idSubasta = idSubasta;
	}

	public String getEstado() {
		return this.estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public Date getFechaFin() {
		return this.fechaFin;
	}

	public void setFechaFin(Date fechaFin) {
		this.fechaFin = fechaFin;
	}

	public Date getFechaInicio() {
		return this.fechaInicio;
	}

	public void setFechaInicio(Date fechaInicio) {
		this.fechaInicio = fechaInicio;
	}

	public int getPrecioInicial() {
		return this.precioInicial;
	}

	public void setPrecioInicial(int precioInicial) {
		this.precioInicial = precioInicial;
	}

	public List<Puja> getPujas() {
		return this.pujas;
	}

	public void setPujas(List<Puja> pujas) {
		this.pujas = pujas;
	}

	public Puja addPuja(Puja puja) {
		getPujas().add(puja);
		puja.setSubasta(this);

		return puja;
	}

	public Puja removePuja(Puja puja) {
		getPujas().remove(puja);
		puja.setSubasta(null);

		return puja;
	}

	public Vivienda getVivienda() {
		return this.vivienda;
	}

	public void setVivienda(Vivienda vivienda) {
		this.vivienda = vivienda;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + idSubasta;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!(obj instanceof Subasta))
			return false;
		Subasta other = (Subasta) obj;
		if (idSubasta != other.idSubasta)
			return false;
		return true;
	}

}