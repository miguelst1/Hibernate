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
@Table(name = "PER_AFI")
public class Aficion {

	@Id
	@GeneratedValue
	@Column(name = "AFI_ID")
	private Integer id;

	@Column(name = "AFI_NOM")
	private String nombre;

	@ManyToMany(mappedBy = "aficiones")
	private List<Persona> personas = new ArrayList<Persona>();

	public Aficion() {

	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

}
