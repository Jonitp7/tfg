package viviendas.modelo.entities;

import java.io.Serializable;
import jakarta.persistence.*;
import java.util.Date;


/**
 * The persistent class for the historico_alquileres database table.
 * 
 */
@Entity
@Table(name="historico_alquileres")
@NamedQuery(name="HistoricoAlquileres.findAll", query="SELECT h FROM HistoricoAlquileres h")
public class HistoricoAlquileres implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="id_historico_alquiler")
	private int idHistoricoAlquiler;

	@Temporal(TemporalType.DATE)
	@Column(name="fecha_cancelacion_alquiler")
	private Date fechaCancelacionAlquiler;

	@Temporal(TemporalType.DATE)
	@Column(name="fecha_entrada_alquiler")
	private Date fechaEntradaAlquiler;

	@Temporal(TemporalType.DATE)
	@Column(name="fecha_salida_alquiler")
	private Date fechaSalidaAlquiler;

	//bi-directional many-to-one association to Usuarios
	@ManyToOne
	@JoinColumn(name="id_usuario")
	private Usuarios usuario;

	//bi-directional many-to-one association to Viviendas
	@ManyToOne
	@JoinColumn(name="id_vivienda")
	private Viviendas vivienda;
	
	@ManyToOne
	@JoinColumn(name="id_alquiler")
	private Alquileres alquiler;

	public HistoricoAlquileres() {
	}

	public int getIdHistoricoAlquiler() {
		return this.idHistoricoAlquiler;
	}

	public void setIdHistoricoAlquiler(int idHistoricoAlquiler) {
		this.idHistoricoAlquiler = idHistoricoAlquiler;
	}

	public Date getFechaCancelacionAlquiler() {
		return this.fechaCancelacionAlquiler;
	}

	public void setFechaCancelacionAlquiler(Date fechaCancelacionAlquiler) {
		this.fechaCancelacionAlquiler = fechaCancelacionAlquiler;
	}

	public Date getFechaEntradaAlquiler() {
		return this.fechaEntradaAlquiler;
	}

	public void setFechaEntradaAlquiler(Date fechaEntradaAlquiler) {
		this.fechaEntradaAlquiler = fechaEntradaAlquiler;
	}

	public Date getFechaSalidaAlquiler() {
		return this.fechaSalidaAlquiler;
	}

	public void setFechaSalidaAlquiler(Date fechaSalidaAlquiler) {
		this.fechaSalidaAlquiler = fechaSalidaAlquiler;
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
	public Alquileres getAlquiler() {
		return this.alquiler;
	}
	
	public void setAlquiler(Alquileres alquileres) {
		this.alquiler = alquileres;
	}

}