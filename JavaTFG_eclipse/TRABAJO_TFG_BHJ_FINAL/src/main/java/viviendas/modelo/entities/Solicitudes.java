package viviendas.modelo.entities;

import java.io.Serializable;
import java.util.Date;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import jakarta.persistence.*;


/**
 * The persistent class for the solicitudes database table.
 * 
 */
@Entity
@NamedQuery(name="Solicitudes.findAll", query="SELECT s FROM Solicitudes s")
public class Solicitudes implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="id_solicitud")
	private int idSolicitud;

	@Column(name="estado_solicitud")
	private String estadoSolicitud;
	
	@Temporal(TemporalType.DATE)
	@Column(name="fecha")
	private Date fecha;
	
	@Column(name = "datos_vivienda")
    private String datosViviendaJson;
	
	@Transient
    private DatosVivienda datosVivienda;

    @PostLoad
    private void postLoad() {
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            this.datosVivienda = objectMapper.readValue(this.datosViviendaJson, DatosVivienda.class);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
    }
    @PrePersist
    @PreUpdate
    private void prePersist() {
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            this.datosViviendaJson = objectMapper.writeValueAsString(this.datosVivienda);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
    }

	//bi-directional many-to-one association to Usuarios
	@ManyToOne
	@JoinColumn(name="id_usuario")
	private Usuarios usuario;

	public Solicitudes() {
	}

	public int getIdSolicitud() {
		return this.idSolicitud;
	}

	public void setIdSolicitud(int idSolicitud) {
		this.idSolicitud = idSolicitud;
	}

	public String getEstadoSolicitud() {
		return this.estadoSolicitud;
	}

	public void setEstadoSolicitud(String estadoSolicitud) {
		this.estadoSolicitud = estadoSolicitud;
	}
	
	public Date getFecha() {
		return this.fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public Usuarios getUsuario() {
		return this.usuario;
	}

	public void setUsuario(Usuarios usuario) {
		this.usuario = usuario;
	}
	public DatosVivienda getDatosVivienda() {
	     return datosVivienda;
	 }

	 public void setDatosVivienda(DatosVivienda datosVivienda) {
	     this.datosVivienda = datosVivienda;
	 }

}