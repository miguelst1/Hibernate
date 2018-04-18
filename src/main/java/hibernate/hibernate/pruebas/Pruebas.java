package hibernate.hibernate.pruebas;

import java.util.Date;
import java.util.List;

import hibernate.hibernate.modelo.Coche;
import hibernate.hibernate.modelo.EstadoCivil;
import hibernate.hibernate.modelo.Persona;
import hibernate.hibernate.repositorio.RepositorioCoche;
import hibernate.hibernate.repositorio.RepositorioPersona;

public class Pruebas {

	public static void main(String[] args) {
		System.out.println(crearPersona());
		consultar("Miguel", "", "", EstadoCivil.SOLTERO);
	}

	private static Integer crearPersona() {
		final Persona persona = new Persona();
		persona.setNombre("Miguel");
		persona.setApellidos("Sanchez Torrijo");
		persona.setEdad(20);
		persona.setEstadoCivil(EstadoCivil.SOLTERO);
		persona.setDni("17477222M");

		return RepositorioPersona.crearPersona(persona);
	}

	private static Integer crearCoche() {
		final Coche coche = new Coche();
		coche.setMatricula("8273DCL");
		coche.setMarca("Opel");
		coche.setModelo("Astra");
		coche.setColor("Rojo");
		coche.setMotor("1400");
		coche.setFechaMatriculacion(new Date());

		return RepositorioCoche.crearCoche(coche);
	}

	private static void modificarPersona() {
		RepositorioPersona.modificarPersona(1, "Pepito");
	}

	private static void eliminarPersona() {
		RepositorioPersona.eliminarPersona(1);
	}

	private static void modificarCoche() {
		RepositorioCoche.modificarCoche(2, "1234AVC");
	}

	private static void eliminarCoche() {
		RepositorioCoche.eliminarCoche(2);
	}

	private static void consultarPersona() {
		RepositorioPersona.consultarPersona(1);
	}

	private static void consultar(String nombre, String apellidos, String dni, EstadoCivil estadoCivil) {
		final List<Persona> lista = RepositorioPersona.consultar(nombre, apellidos, dni, estadoCivil);

		System.out.println(lista.size());
	}

}
