package viviendas.modelo.entities;

import java.io.Serializable;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;


/**
 * The persistent class for the compradores database table.
 * 
 */
@Entity
@Table(name="compradores")
@NamedQuery(name="Comprador.findAll", query="SELECT c FROM Comprador c")
public class Comprador implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="id_comprador")
	private int idComprador;

	//bi-directional many-to-one association to Alquiler
	@OneToMany(mappedBy="comprador")
	private List<Alquiler> Alquiler;

	//bi-directional many-to-one association to Usuario
	@ManyToOne
	@JoinColumn(name="username")
	private Usuario usuario;

	//bi-directional many-to-one association to Puja
	@OneToMany(mappedBy="comprador")
	private List<Puja> pujas;

	//bi-directional many-to-one association to Venta
	@OneToMany(mappedBy="comprador")
	private List<Venta> ventas;
	
	
	@ManyToMany
	@JoinTable(
		name="favoritos"
		, joinColumns={
			@JoinColumn(name="id_comprador")
			}
		, inverseJoinColumns={
			@JoinColumn(name="id_vivienda")
			}
		)
	private List<Vivienda> viviendas;

	public Comprador() {
	}

	public int getIdComprador() {
		return this.idComprador;
	}

	public void setIdComprador(int idComprador) {
		this.idComprador = idComprador;
	}

	public List<Alquiler> getAlquiler() {
		return this.Alquiler;
	}

	public void setAlquiler(List<Alquiler> Alquiler) {
		this.Alquiler = Alquiler;
	}

	public Alquiler addAlquiler(Alquiler Alquiler) {
		getAlquiler().add(Alquiler);
		Alquiler.setComprador(this);

		return Alquiler;
	}

	public Alquiler removeAlquiler(Alquiler Alquiler) {
		getAlquiler().remove(Alquiler);
		Alquiler.setComprador(null);

		return Alquiler;
	}

	public Usuario getUsuario() {
		return this.usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public List<Puja> getPujas() {
		return this.pujas;
	}

	public void setPujas(List<Puja> pujas) {
		this.pujas = pujas;
	}

	public Puja addPuja(Puja puja) {
		getPujas().add(puja);
		puja.setComprador(this);

		return puja;
	}

	public Puja removePuja(Puja puja) {
		getPujas().remove(puja);
		puja.setComprador(null);

		return puja;
	}

	public List<Venta> getVentas() {
		return this.ventas;
	}

	public void setVentas(List<Venta> ventas) {
		this.ventas = ventas;
	}

	public Venta addVenta(Venta venta) {
		getVentas().add(venta);
		venta.setComprador(this);

		return venta;
	}

	public Venta removeVenta(Venta venta) {
		getVentas().remove(venta);
		venta.setComprador(null);

		return venta;
	}
	

	public List<Vivienda> getViviendas() {
		return this.viviendas;
	}

	public void setViviendas(List<Vivienda> viviendas) {
		this.viviendas = viviendas;
	}

	public void addPerfil(Vivienda vivienda) {
		if (viviendas == null)
			viviendas = new ArrayList<>();
		viviendas.add(vivienda);
	}
	
	public void removePerfil(Vivienda vivienda) {
		if (viviendas == null)
			viviendas = new ArrayList<>();
		viviendas.remove(vivienda);
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + idComprador;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!(obj instanceof Comprador))
			return false;
		Comprador other = (Comprador) obj;
		if (idComprador != other.idComprador)
			return false;
		return true;
	}

}