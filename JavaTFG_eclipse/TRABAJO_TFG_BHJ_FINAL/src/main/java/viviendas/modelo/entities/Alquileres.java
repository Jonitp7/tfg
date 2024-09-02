package viviendas.modelo.entities;

import java.io.Serializable;
import jakarta.persistence.*;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonIgnore;


/**
 * The persistent class for the alquileres database table.
 * 
 */
@Entity
@NamedQuery(name="Alquileres.findAll", query="SELECT a FROM Alquileres a")
public class Alquileres implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="id_alquiler")
	private int idAlquiler;

	@Column(name="estado_alquiler")
	private String estadoAlquiler;

	@Temporal(TemporalType.DATE)
	@Column(name="fecha_entrada")
	private Date fechaEntrada;

	@Temporal(TemporalType.DATE)
	@Column(name="fecha_salida")
	private Date fechaSalida;

	private int personas;

	@Column(name="precio_cancelacion")
	private int precioCancelacion;

	@Column(name="precio_noche")
	private int precioNoche;

	//bi-directional many-to-one association to Viviendas
	@ManyToOne
	@JoinColumn(name="id_vivienda")
	private Viviendas vivienda;

	//bi-directional many-to-one association to Usuarios
	@ManyToOne
	@JoinColumn(name="id_usuario")
	private Usuarios usuario;

	public Alquileres() {
	}

	public int getIdAlquiler() {
		return this.idAlquiler;
	}

	public void setIdAlquiler(int idAlquiler) {
		this.idAlquiler = idAlquiler;
	}

	public String getEstadoAlquiler() {
		return this.estadoAlquiler;
	}

	public void setEstadoAlquiler(String estadoAlquiler) {
		this.estadoAlquiler = estadoAlquiler;
	}

	public Date getFechaEntrada() {
		return this.fechaEntrada;
	}

	public void setFechaEntrada(Date fechaEntrada) {
		this.fechaEntrada = fechaEntrada;
	}

	public Date getFechaSalida() {
		return this.fechaSalida;
	}

	public void setFechaSalida(Date fechaSalida) {
		this.fechaSalida = fechaSalida;
	}

	public int getPersonas() {
		return this.personas;
	}

	public void setPersonas(int personas) {
		this.personas = personas;
	}

	public int getPrecioCancelacion() {
		return this.precioCancelacion;
	}

	public void setPrecioCancelacion(int precioCancelacion) {
		this.precioCancelacion = precioCancelacion;
	}

	public int getPrecioNoche() {
		return this.precioNoche;
	}

	public void setPrecioNoche(int precioNoche) {
		this.precioNoche = precioNoche;
	}

	public Viviendas getVivienda() {
		return this.vivienda;
	}

	public void setVivienda(Viviendas vivienda) {
		this.vivienda = vivienda;
	}

	public Usuarios getUsuario() {
		return this.usuario;
	}

	public void setUsuario(Usuarios usuario) {
		this.usuario = usuario;
	}

}