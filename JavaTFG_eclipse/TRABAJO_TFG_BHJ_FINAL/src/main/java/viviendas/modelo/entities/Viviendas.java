package viviendas.modelo.entities;

import java.io.Serializable;
import jakarta.persistence.*;
import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;


/**
 * The persistent class for the viviendas database table.
 * 
 */
@Entity
@NamedQuery(name="Viviendas.findAll", query="SELECT v FROM Viviendas v")
public class Viviendas implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="id_vivienda")
	private int idVivienda;

	@Temporal(TemporalType.DATE)
	@Column(name="fecha_construccion")
	private Date fechaConstruccion;

	@Column(name="aseos_habitacion")
	private int aseosHabitacion;

	private int aseos;

	private String descripcion;

	@Column(name="existencia_subasta")
	private byte existenciaSubasta;

	private String extension;

	@Temporal(TemporalType.DATE)
	@Column(name="fecha_alta_vivienda")
	private Date fechaAltaVivienda;

	@Temporal(TemporalType.DATE)
	@Column(name="fecha_cancelacion_vivienda")
	private Date fechaCancelacionVivienda;

	private boolean garaje;

	private boolean golf;

	private int habitaciones;

	private boolean jardin;

	private boolean piscina;

	private int plantas;

	private boolean spa;

	@Column(name="tipo_vivienda")
	private String tipoVivienda;

	private String ubicacion;

	private int valoracion;

	private String vista;

	//bi-directional many-to-one association to Alquileres
	@OneToMany(mappedBy="vivienda")
	@JsonIgnore
	private List<Alquileres> alquileres;

	//bi-directional many-to-one association to Favoritos
	@OneToMany(mappedBy="vivienda")
	@JsonIgnore
	private List<Favoritos> favoritos;

	//bi-directional many-to-one association to HistoricoAlquileres
	@OneToMany(mappedBy="vivienda")
	@JsonIgnore
	private List<HistoricoAlquileres> historicoAlquileres;

	//bi-directional many-to-one association to HistoricoSubastas
	@OneToMany(mappedBy="vivienda")
	@JsonIgnore
	private List<HistoricoSubastas> historicoSubastas;

	//bi-directional many-to-one association to Opiniones
	@OneToMany(mappedBy="vivienda")
	@JsonIgnore
	private List<Opiniones> opiniones;

	//bi-directional many-to-one association to Subastas
	@OneToMany(mappedBy="vivienda")
	@JsonIgnore
	private List<Subastas> subastas;

	//bi-directional many-to-one association to Usuarios
	@ManyToOne
	@JoinColumn(name="id_usuario")
	private Usuarios usuario;
	
	@Column(name = "fotos_vivienda")
    private String fotosViviendaJson;
	
	@Transient
    private FotosVivienda fotosVivienda;

    @PostLoad
    private void postLoad() {
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            this.fotosVivienda = objectMapper.readValue(this.fotosViviendaJson, FotosVivienda.class);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
    }
    @PrePersist
    @PreUpdate
    private void prePersist() {
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            this.fotosViviendaJson = objectMapper.writeValueAsString(this.fotosVivienda);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
    }

	public Viviendas() {
	}

	public int getIdVivienda() {
		return this.idVivienda;
	}

	public void setIdVivienda(int idVivienda) {
		this.idVivienda = idVivienda;
	}

	public Date getFechaConstruccion() {
		return this.fechaConstruccion;
	}

	public void setFechaConstruccion(Date fechaConstruccion) {
		this.fechaConstruccion = fechaConstruccion;
	}

	public int getAseosHabitacion() {
		return this.aseosHabitacion;
	}

	public void setAseosHabitacion(int aseosHabitacion) {
		this.aseosHabitacion = aseosHabitacion;
	}

	public int getAseos() {
		return this.aseos;
	}

	public void setAseos(int aseos) {
		this.aseos = aseos;
	}

	public String getDescripcion() {
		return this.descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public byte getExistenciaSubasta() {
		return this.existenciaSubasta;
	}

	public void setExistenciaSubasta(byte existenciaSubasta) {
		this.existenciaSubasta = existenciaSubasta;
	}

	public String getExtension() {
		return this.extension;
	}

	public void setExtension(String extension) {
		this.extension = extension;
	}

	public Date getFechaAltaVivienda() {
		return this.fechaAltaVivienda;
	}

	public void setFechaAltaVivienda(Date fechaAltaVivienda) {
		this.fechaAltaVivienda = fechaAltaVivienda;
	}

	public Date getFechaCancelacionVivienda() {
		return this.fechaCancelacionVivienda;
	}

	public void setFechaCancelacionVivienda(Date fechaCancelacionVivienda) {
		this.fechaCancelacionVivienda = fechaCancelacionVivienda;
	}

	public boolean getGaraje() {
		return this.garaje;
	}

	public void setGaraje(boolean garaje) {
		this.garaje = garaje;
	}

	public boolean getGolf() {
		return this.golf;
	}

	public void setGolf(boolean golf) {
		this.golf = golf;
	}

	public int getHabitaciones() {
		return this.habitaciones;
	}

	public void setHabitaciones(int habitaciones) {
		this.habitaciones = habitaciones;
	}

	public boolean getJardin() {
		return this.jardin;
	}

	public void setJardin(boolean jardin) {
		this.jardin = jardin;
	}

	public boolean getPiscina() {
		return this.piscina;
	}

	public void setPiscina(boolean piscina) {
		this.piscina = piscina;
	}

	public int getPlantas() {
		return this.plantas;
	}

	public void setPlantas(int plantas) {
		this.plantas = plantas;
	}

	public boolean getSpa() {
		return this.spa;
	}

	public void setSpa(boolean spa) {
		this.spa = spa;
	}

	public String getTipoVivienda() {
		return this.tipoVivienda;
	}

	public void setTipoVivienda(String tipoVivienda) {
		this.tipoVivienda = tipoVivienda;
	}

	public String getUbicacion() {
		return this.ubicacion;
	}

	public void setUbicacion(String ubicacion) {
		this.ubicacion = ubicacion;
	}

	public int getValoracion() {
		return this.valoracion;
	}

	public void setValoracion(int valoracion) {
		this.valoracion = valoracion;
	}

	public String getVista() {
		return this.vista;
	}

	public void setVista(String vista) {
		this.vista = vista;
	}

	public List<Alquileres> getAlquileres() {
		return this.alquileres;
	}

	public void setAlquileres(List<Alquileres> alquileres) {
		this.alquileres = alquileres;
	}

	public Alquileres addAlquilere(Alquileres alquilere) {
		getAlquileres().add(alquilere);
		alquilere.setVivienda(this);

		return alquilere;
	}

	public Alquileres removeAlquilere(Alquileres alquilere) {
		getAlquileres().remove(alquilere);
		alquilere.setVivienda(null);

		return alquilere;
	}

	public List<Favoritos> getFavoritos() {
		return this.favoritos;
	}

	public void setFavoritos(List<Favoritos> favoritos) {
		this.favoritos = favoritos;
	}

	public Favoritos addFavorito(Favoritos favorito) {
		getFavoritos().add(favorito);
		favorito.setVivienda(this);

		return favorito;
	}

	public Favoritos removeFavorito(Favoritos favorito) {
		getFavoritos().remove(favorito);
		favorito.setVivienda(null);

		return favorito;
	}

	public List<HistoricoAlquileres> getHistoricoAlquileres() {
		return this.historicoAlquileres;
	}

	public void setHistoricoAlquileres(List<HistoricoAlquileres> historicoAlquileres) {
		this.historicoAlquileres = historicoAlquileres;
	}

	public HistoricoAlquileres addHistoricoAlquilere(HistoricoAlquileres historicoAlquilere) {
		getHistoricoAlquileres().add(historicoAlquilere);
		historicoAlquilere.setVivienda(this);

		return historicoAlquilere;
	}

	public HistoricoAlquileres removeHistoricoAlquilere(HistoricoAlquileres historicoAlquilere) {
		getHistoricoAlquileres().remove(historicoAlquilere);
		historicoAlquilere.setVivienda(null);

		return historicoAlquilere;
	}

	public List<HistoricoSubastas> getHistoricoSubastas() {
		return this.historicoSubastas;
	}

	public void setHistoricoSubastas(List<HistoricoSubastas> historicoSubastas) {
		this.historicoSubastas = historicoSubastas;
	}

	public HistoricoSubastas addHistoricoSubasta(HistoricoSubastas historicoSubasta) {
		getHistoricoSubastas().add(historicoSubasta);
		historicoSubasta.setVivienda(this);

		return historicoSubasta;
	}

	public HistoricoSubastas removeHistoricoSubasta(HistoricoSubastas historicoSubasta) {
		getHistoricoSubastas().remove(historicoSubasta);
		historicoSubasta.setVivienda(null);

		return historicoSubasta;
	}

	public List<Opiniones> getOpiniones() {
		return this.opiniones;
	}

	public void setOpiniones(List<Opiniones> opiniones) {
		this.opiniones = opiniones;
	}

	public Opiniones addOpinione(Opiniones opinione) {
		getOpiniones().add(opinione);
		opinione.setVivienda(this);

		return opinione;
	}

	public Opiniones removeOpinione(Opiniones opinione) {
		getOpiniones().remove(opinione);
		opinione.setVivienda(null);

		return opinione;
	}

	public List<Subastas> getSubastas() {
		return this.subastas;
	}

	public void setSubastas(List<Subastas> subastas) {
		this.subastas = subastas;
	}

	public Subastas addSubasta(Subastas subasta) {
		getSubastas().add(subasta);
		subasta.setVivienda(this);

		return subasta;
	}

	public Subastas removeSubasta(Subastas subasta) {
		getSubastas().remove(subasta);
		subasta.setVivienda(null);

		return subasta;
	}

	public Usuarios getUsuario() {
		return this.usuario;
	}

	public void setUsuario(Usuarios usuario) {
		this.usuario = usuario;
	}
	
	public FotosVivienda getFotosVivienda() {
	     return fotosVivienda;
	 }

	 public void setFotosViviendaa(FotosVivienda fotosVivienda) {
	     this.fotosVivienda = fotosVivienda;
	 }

}