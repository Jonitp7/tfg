package viviendas.modelo.entities;

import java.io.Serializable;
import jakarta.persistence.*;
import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;


/**
 * The persistent class for the subastas database table.
 * 
 */
@Entity
@NamedQuery(name="Subastas.findAll", query="SELECT s FROM Subastas s")
public class Subastas implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="id_subasta")
	private int idSubasta;

	@Column(name="estado_subasta")
	private String estadoSubasta;

	@Temporal(TemporalType.DATE)
	@Column(name="fecha_fin")
	private Date fechaFin;

	@Temporal(TemporalType.DATE)
	@Column(name="fecha_inicio")
	private Date fechaInicio;

	@Column(name="precio_inicial")
	private int precioInicial;

	//bi-directional many-to-one association to HistoricoSubastas
	@OneToMany(mappedBy="subasta")
	@JsonIgnore
	private List<HistoricoSubastas> historicoSubastas;

	//bi-directional many-to-one association to Pujas
	@OneToMany(mappedBy="subasta")
	@JsonIgnore
	private List<Pujas> pujas;

	//bi-directional many-to-one association to Viviendas
	@ManyToOne
	@JoinColumn(name="id_vivienda")
	private Viviendas vivienda;
	
	@ManyToOne
	@JoinColumn(name="id_usuario")
	private Usuarios usuario;

	public Subastas() {
	}

	public int getIdSubasta() {
		return this.idSubasta;
	}

	public void setIdSubasta(int idSubasta) {
		this.idSubasta = idSubasta;
	}

	public String getEstadoSubasta() {
		return this.estadoSubasta;
	}

	public void setEstadoSubasta(String estadoSubasta) {
		this.estadoSubasta = estadoSubasta;
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

	public List<HistoricoSubastas> getHistoricoSubastas() {
		return this.historicoSubastas;
	}

	public void setHistoricoSubastas(List<HistoricoSubastas> historicoSubastas) {
		this.historicoSubastas = historicoSubastas;
	}

	public HistoricoSubastas addHistoricoSubasta(HistoricoSubastas historicoSubasta) {
		getHistoricoSubastas().add(historicoSubasta);
		historicoSubasta.setSubasta(this);

		return historicoSubasta;
	}

	public HistoricoSubastas removeHistoricoSubasta(HistoricoSubastas historicoSubasta) {
		getHistoricoSubastas().remove(historicoSubasta);
		historicoSubasta.setSubasta(null);

		return historicoSubasta;
	}

	public List<Pujas> getPujas() {
		return this.pujas;
	}

	public void setPujas(List<Pujas> pujas) {
		this.pujas = pujas;
	}

	public Pujas addPuja(Pujas puja) {
		getPujas().add(puja);
		puja.setSubasta(this);

		return puja;
	}

	public Pujas removePuja(Pujas puja) {
		getPujas().remove(puja);
		puja.setSubasta(null);

		return puja;
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