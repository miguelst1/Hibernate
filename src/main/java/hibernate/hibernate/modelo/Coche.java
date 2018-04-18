package hibernate.hibernate.modelo;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "A_COC")
public class Coche implements Serializable {

	@Id
	@GeneratedValue
	@Column(name = "COC_ID")
	private int idCoche;

	@Column(name = "COC_MAT", nullable = false, length = 7)
	private String matricula;

	@Column(name = "COC_MOT", nullable = false)
	private String motor;

	@Column(name = "COC_ANM", nullable = false)
	private Date fechaMatriculacion;

	@Column(name = "COC_MAR", nullable = false)
	private String marca;

	@Column(name = "COC_MOD", nullable = false)
	private String modelo;

	@Column(name = "COC_COL")
	private String color;

	public Coche() {

	}

	public int getIdCoche() {
		return idCoche;
	}

	public void setIdCoche(int idCoche) {
		this.idCoche = idCoche;
	}

	public String getMatricula() {
		return matricula;
	}

	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}

	public String getMotor() {
		return motor;
	}

	public void setMotor(String motor) {
		this.motor = motor;
	}

	public Date getfechaMatriculacion() {
		return fechaMatriculacion;
	}

	public void setFechaMatriculacion(Date fechaMatriculacion) {
		this.fechaMatriculacion = fechaMatriculacion;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

}
