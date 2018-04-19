package hibernate.hibernate.modelo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "PER_DET")
public class DetallesPersona {

	@Id
	@GeneratedValue
	@Column(name = "DET_ID")
	private Integer id;

	@Column(name = "DET_HIJ")
	private Boolean tieneHijos;

	@Column(name = "DET_MAS")
	private Boolean tieneMascota;

	@Column(name = "DET_DEP")
	private Boolean practicaDeporte;

	@Column(name = "DET_PER")
	private Persona persona;

	public DetallesPersona() {

	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Boolean getTieneHijos() {
		return tieneHijos;
	}

	public void setTieneHijos(Boolean tieneHijos) {
		this.tieneHijos = tieneHijos;
	}

	public Boolean getTieneMascota() {
		return tieneMascota;
	}

	public void setTieneMascota(Boolean tieneMascota) {
		this.tieneMascota = tieneMascota;
	}

	public Boolean getPracticaDeporte() {
		return practicaDeporte;
	}

	public void setPracticaDeporte(Boolean practicaDeporte) {
		this.practicaDeporte = practicaDeporte;
	}
}
