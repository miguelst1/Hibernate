package hibernate.hibernate.modelo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "PER_TEL")
public class Telefono {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequence-generator")
	@SequenceGenerator(name = "sequence-generator", sequenceName = "PER_TEL_sequence", initialValue = 50, allocationSize = 10)
	@Column(name = "TEL_ID")
	private Integer id;

	@Column(name = "TEL_NUM", nullable = false)
	private String numero;

	@ManyToOne
	private Persona persona;

	public Telefono() {

	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public Persona getPersona() {
		return persona;
	}

	public void setPersona(Persona persona) {
		this.persona = persona;
	}
}
