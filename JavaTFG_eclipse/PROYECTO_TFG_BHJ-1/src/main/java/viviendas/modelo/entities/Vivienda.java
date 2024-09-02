package viviendas.modelo.entities;

import java.io.Serializable;
import jakarta.persistence.*;
import lombok.Builder;
import lombok.Data;

import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;


/**
 * The persistent class for the viviendas database table.
 * 
 */
@Entity
@Table(name="viviendas")
@NamedQuery(name="Vivienda.findAll", query="SELECT v FROM Vivienda v")
public class Vivienda implements Serializable {
	

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="id_vivienda")
	private int idVivienda;

	@Temporal(TemporalType.DATE)
	@Column(name="año_construccion")
	private Date añoConstruccion;

	private int baños;

	private String descripcion;

	private String estado;

	private String extension;

	private byte garaje;

	private int habitaciones;

	private int plantas;

	private int precio;

	private String ubicacion;

	//bi-directional many-to-one association to Alquiler
	@OneToMany(mappedBy="vivienda")
	@JsonIgnore
	private List<Alquiler> Alquilers;

	//bi-directional many-to-one association to Subasta
	@OneToMany(mappedBy="vivienda")
	@JsonIgnore
	private List<Subasta> subastas;

	//bi-directional many-to-one association to Venta
	@OneToMany(mappedBy="vivienda")
	@JsonIgnore
	private List<Venta> ventas;

	//bi-directional many-to-one association to Propietario
	@ManyToOne
	@JoinColumn(name="id_propietario")
	private Propietario propietario;

	public Vivienda() {
	}

	public int getIdVivienda() {
		return this.idVivienda;
	}

	public void setIdVivienda(int idVivienda) {
		this.idVivienda = idVivienda;
	}

	public Date getAñoConstruccion() {
		return this.añoConstruccion;
	}

	public void setAñoConstruccion(Date añoConstruccion) {
		this.añoConstruccion = añoConstruccion;
	}

	public int getBaños() {
		return this.baños;
	}

	public void setBaños(int baños) {
		this.baños = baños;
	}

	public String getDescripcion() {
		return this.descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getEstado() {
		return this.estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public String getExtension() {
		return this.extension;
	}

	public void setExtension(String extension) {
		this.extension = extension;
	}

	public byte getGaraje() {
		return this.garaje;
	}

	public void setGaraje(byte garaje) {
		this.garaje = garaje;
	}

	public int getHabitaciones() {
		return this.habitaciones;
	}

	public void setHabitaciones(int habitaciones) {
		this.habitaciones = habitaciones;
	}

	public int getPlantas() {
		return this.plantas;
	}

	public void setPlantas(int plantas) {
		this.plantas = plantas;
	}

	public int getPrecio() {
		return this.precio;
	}

	public void setPrecio(int precio) {
		this.precio = precio;
	}

	public String getUbicacion() {
		return this.ubicacion;
	}

	public void setUbicacion(String ubicacion) {
		this.ubicacion = ubicacion;
	}

	public List<Alquiler> getAlquilers() {
		return this.Alquilers;
	}

	public void setAlquilers(List<Alquiler> Alquilers) {
		this.Alquilers = Alquilers;
	}

	public Alquiler addAlquiler(Alquiler Alquiler) {
		getAlquilers().add(Alquiler);
		Alquiler.setVivienda(this);

		return Alquiler;
	}

	public Alquiler removeAlquiler(Alquiler Alquiler) {
		getAlquilers().remove(Alquiler);
		Alquiler.setVivienda(null);

		return Alquiler;
	}

	public List<Subasta> getSubastas() {
		return this.subastas;
	}

	public void setSubastas(List<Subasta> subastas) {
		this.subastas = subastas;
	}

	public Subasta addSubasta(Subasta subasta) {
		getSubastas().add(subasta);
		subasta.setVivienda(this);

		return subasta;
	}

	public Subasta removeSubasta(Subasta subasta) {
		getSubastas().remove(subasta);
		subasta.setVivienda(null);

		return subasta;
	}

	public List<Venta> getVentas() {
		return this.ventas;
	}

	public void setVentas(List<Venta> ventas) {
		this.ventas = ventas;
	}

	public Venta addVenta(Venta venta) {
		getVentas().add(venta);
		venta.setVivienda(this);

		return venta;
	}

	public Venta removeVenta(Venta venta) {
		getVentas().remove(venta);
		venta.setVivienda(null);

		return venta;
	}

	public Propietario getPropietario() {
		return this.propietario;
	}

	public void setPropietario(Propietario propietario) {
		this.propietario = propietario;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + idVivienda;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!(obj instanceof Vivienda))
			return false;
		Vivienda other = (Vivienda) obj;
		if (idVivienda != other.idVivienda)
			return false;
		return true;
	}

}