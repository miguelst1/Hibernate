package hibernate.hibernate.modelo;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "PER_DIR")
public class Direccion {

	@Id
	@GeneratedValue
	@Column(name = "DIR_ID")
	private Integer idDireccion;

	@Column(name = "DIR_PRO", nullable = false)
	private String provincia;

	@Column(name = "DIR_CIU", nullable = false)
	private String ciudad;

	@Column(name = "DIR_COP", nullable = false)
	private String codigoPostal;

	@Column(name = "DIR_CAL", nullable = false)
	private String calle;

	@Column(name = "DIR_NUM", nullable = false)
	private Integer numero;

	@Column(name = "DIR_BLO")
	private Integer bloque;

	@Column(name = "DIR_PLA")
	private Integer planta;

	@Column(name = "DIR_PUE")
	private String puerta;

	@ManyToMany(mappedBy = "direcciones")
	private List<Persona> personas = new ArrayList<Persona>();

	public Direccion() {

	}

	public Integer getIdDireccion() {
		return idDireccion;
	}

	public void setIdDireccion(Integer idDireccion) {
		this.idDireccion = idDireccion;
	}

	public String getProvincia() {
		return provincia;
	}

	public void setProvincia(String provincia) {
		this.provincia = provincia;
	}

	public String getCiudad() {
		return ciudad;
	}

	public void setCiudad(String ciudad) {
		this.ciudad = ciudad;
	}

	public String getCodigoPostal() {
		return codigoPostal;
	}

	public void setCodigoPostal(String codigoPostal) {
		this.codigoPostal = codigoPostal;
	}

	public String getCalle() {
		return calle;
	}

	public void setCalle(String calle) {
		this.calle = calle;
	}

	public Integer getNumero() {
		return numero;
	}

	public void setNumero(Integer numero) {
		this.numero = numero;
	}

	public Integer getBloque() {
		return bloque;
	}

	public void setBloque(Integer bloque) {
		this.bloque = bloque;
	}

	public Integer getPlanta() {
		return planta;
	}

	public void setPlanta(Integer planta) {
		this.planta = planta;
	}

	public String getPuerta() {
		return puerta;
	}

	public void setPuerta(String puerta) {
		this.puerta = puerta;
	}

	public List<Persona> getPersonas() {
		return personas;
	}

	public void setPersonas(List<Persona> personas) {
		this.personas = personas;
	}

}
