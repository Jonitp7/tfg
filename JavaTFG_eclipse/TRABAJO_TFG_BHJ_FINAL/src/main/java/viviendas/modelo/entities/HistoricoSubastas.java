package viviendas.modelo.entities;

import java.io.Serializable;
import jakarta.persistence.*;
import java.util.Date;


/**
 * The persistent class for the historico_subastas database table.
 * 
 */
@Entity
@Table(name="historico_subastas")
@NamedQuery(name="HistoricoSubastas.findAll", query="SELECT h FROM HistoricoSubastas h")
public class HistoricoSubastas implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="id_historico_subastas")
	private int idHistoricoSubastas;
	
	@Column(name="precio_venta")
	private int precioVenta;

	@Temporal(TemporalType.DATE)
	@Column(name="fecha_cancelacion_subasta")
	private Date fechaCancelacionSubasta;

	@Temporal(TemporalType.DATE)
	@Column(name="fecha_fin_subasta")
	private Date fechaFinSubasta;

	@Temporal(TemporalType.DATE)
	@Column(name="fecha_inicio_subasta")
	private Date fechaInicioSubasta;

	//bi-directional many-to-one association to Usuarios
	@ManyToOne
	@JoinColumn(name="id_usuario")
	private Usuarios usuario;

	//bi-directional many-to-one association to Viviendas
	@ManyToOne
	@JoinColumn(name="id_vivienda")
	private Viviendas vivienda;

	//bi-directional many-to-one association to Subastas
	@ManyToOne
	@JoinColumn(name="id_subasta")
	private Subastas subasta;

	public HistoricoSubastas() {
	}

	public int getIdHistoricoSubastas() {
		return this.idHistoricoSubastas;
	}

	public void setIdHistoricoSubastas(int idHistoricoSubastas) {
		this.idHistoricoSubastas = idHistoricoSubastas;
	}

	public Date fechaCancelacionSubasta() {
		return this.fechaCancelacionSubasta;
	}

	public void fechaCancelacionSubasta(Date fechaCancelacionSubasta) {
		this.fechaCancelacionSubasta = fechaCancelacionSubasta;
	}
	
	public Date getFechaCancelacionSubasta() {
		return fechaCancelacionSubasta;
	}

	public void setFechaCancelacionSubasta(Date fechaCancelacionSubasta) {
		this.fechaCancelacionSubasta = fechaCancelacionSubasta;
	}

	public void setPrecioVenta(int precioVenta) {
		this.precioVenta = precioVenta;
	}

	public int getPrecioVenta() {
		return this.precioVenta;
	}

	public void setgetPrecioVenta(int precioVenta) {
		this.precioVenta = precioVenta;
	}

	public Date getFechaFinSubasta() {
		return this.fechaFinSubasta;
	}

	public void setFechaFinSubasta(Date fechaFinSubasta) {
		this.fechaFinSubasta = fechaFinSubasta;
	}

	public Date getFechaInicioSubasta() {
		return this.fechaInicioSubasta;
	}

	public void setFechaInicioSubasta(Date fechaInicioSubasta) {
		this.fechaInicioSubasta = fechaInicioSubasta;
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

	public Subastas getSubasta() {
		return this.subasta;
	}

	public void setSubasta(Subastas subasta) {
		this.subasta = subasta;
	}

}