package hibernate.hibernate.modelo;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.Enumerated;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "A_PER")
public class Persona extends Usuario {

	@Column(name = "PER_NOM", nullable = false, length = 50)
	private String nombre;

	@Column(name = "PER_APE", nullable = false, length = 250)
	private String apellidos;

	@Column(name = "PER_DNI", nullable = false, length = 9, unique = true)
	private String dni;

	@Column(name = "PER_EDA", nullable = false)
	private Integer edad;

	@Column(name = "PER_ECV", nullable = false)
	@Enumerated
	private EstadoCivil estadoCivil;

	@ManyToMany(cascade = { CascadeType.ALL })
	private List<Direccion> direcciones = new ArrayList<Direccion>();

	@OneToMany(mappedBy = "persona", cascade = CascadeType.ALL, orphanRemoval = true)
	private Set<Telefono> telefonos = new HashSet<Telefono>();

	@ManyToMany(cascade = { CascadeType.PERSIST, CascadeType.REFRESH, CascadeType.MERGE })
	private List<Aficion> aficiones = new ArrayList<Aficion>();

	@Column(name = "PER_GEN")
	@Convert(converter = GeneroConverter.class)
	private Genero genero;

	public Persona() {

	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellidos() {
		return apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	public Integer getEdad() {
		return edad;
	}

	public void setEdad(Integer edad) {
		this.edad = edad;
	}

	public EstadoCivil getEstadoCivil() {
		return estadoCivil;
	}

	public void setEstadoCivil(EstadoCivil estadoCivil) {
		this.estadoCivil = estadoCivil;
	}

	public List<Direccion> getDirecciones() {
		return direcciones;
	}

	public void setDirecciones(List<Direccion> direcciones) {
		this.direcciones = direcciones;
	}

	public Set<Telefono> getTelefonos() {
		return telefonos;
	}

	public void setTelefonos(Set<Telefono> telefonos) {
		this.telefonos = telefonos;
	}

	public List<Aficion> getAficiones() {
		return aficiones;
	}

	public Genero getGenero() {
		return genero;
	}

	public void setGenero(Genero genero) {
		this.genero = genero;
	}

	public void setAficiones(List<Aficion> aficiones) {
		this.aficiones = aficiones;
	}

	public void agregarDireccion(Direccion direccion) {
		direcciones.add(direccion);
		direccion.getPersonas().add(this);
	}

	public void eliminarDireccion(Direccion direccion) {
		direcciones.remove(direccion);
		direccion.getPersonas().remove(this);
	}

	public void agregarTelefono(Telefono telefono) {
		telefonos.add(telefono);
		telefono.setPersona(this);
	}

	public void eliminarTelefono(Telefono telefono) {
		telefonos.remove(telefono);
		telefono.setPersona(null);
	}

}
