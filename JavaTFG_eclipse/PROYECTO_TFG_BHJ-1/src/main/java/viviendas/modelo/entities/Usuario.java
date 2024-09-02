package viviendas.modelo.entities;

import java.io.Serializable;
import jakarta.persistence.*;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;


/**
 * The persistent class for the usuarios database table.
 * 
 */
@Entity
@Table(name="usuarios")
@NamedQuery(name="Usuario.findAll", query="SELECT u FROM Usuario u")
public class Usuario implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private String username;

	private String apellido;

	@Column(name="archivo_foto")
	private String archivoFoto;

	private String contraseña;

	private String dni;

	private String nombre;

	//bi-directional many-to-one association to Compradore
	@OneToMany(mappedBy="usuario")
	@JsonIgnore
	private List<Comprador> comprador;

	//bi-directional many-to-one association to Propietario
	@OneToMany(mappedBy="usuario")
	@JsonIgnore
	private List<Propietario> propietarios;

	public Usuario() {
	}

	public String getUsername() {
		return this.username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getApellido() {
		return this.apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getArchivoFoto() {
		return this.archivoFoto;
	}

	public void setArchivoFoto(String archivoFoto) {
		this.archivoFoto = archivoFoto;
	}

	public String getContraseña() {
		return this.contraseña;
	}

	public void setContraseña(String contraseña) {
		this.contraseña = contraseña;
	}

	public String getDni() {
		return this.dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public List<Comprador> getComprador() {
		return this.comprador;
	}

	public void setCompradores(List<Comprador> comprador) {
		this.comprador = comprador;
	}

	public Comprador addComprador(Comprador comprador) {
		getComprador().add(comprador);
		comprador.setUsuario(this);

		return comprador;
	}

	public Comprador removeComprador(Comprador comprador) {
		getComprador().remove(comprador);
		comprador.setUsuario(null);

		return comprador;
	}

	public List<Propietario> getPropietarios() {
		return this.propietarios;
	}

	public void setPropietarios(List<Propietario> propietarios) {
		this.propietarios = propietarios;
	}

	public Propietario addPropietario(Propietario propietario) {
		getPropietarios().add(propietario);
		propietario.setUsuario(this);

		return propietario;
	}

	public Propietario removePropietario(Propietario propietario) {
		getPropietarios().remove(propietario);
		propietario.setUsuario(null);

		return propietario;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((username == null) ? 0 : username.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!(obj instanceof Usuario))
			return false;
		Usuario other = (Usuario) obj;
		if (username == null) {
			if (other.username != null)
				return false;
		} else if (!username.equals(other.username))
			return false;
		return true;
	}

}