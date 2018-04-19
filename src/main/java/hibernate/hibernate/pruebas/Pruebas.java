package hibernate.hibernate.pruebas;

import java.util.Date;
import java.util.List;

import hibernate.hibernate.modelo.Cliente;
import hibernate.hibernate.modelo.Direccion;
import hibernate.hibernate.modelo.EstadoCivil;
import hibernate.hibernate.modelo.Persona;
import hibernate.hibernate.modelo.Telefono;
import hibernate.hibernate.repositorio.RepositorioCliente;
import hibernate.hibernate.repositorio.RepositorioPersona;

public class Pruebas {

	public static void main(String[] args) {
		crearPersona("11111111A", "sa");
		crearPersona("11111111C", "sa2");
		crearCliente("22222222B", "sa1");
		crearCliente("22222222D", "sa3");
		modificarPersona();
		eliminarPersona(1);
		// modificarCliente();
		// consultarPersona("%Miguel%", "", "", null, "sa2");
		// consultarCliente("%Miguel%", "", "", null);
	}

	private static Integer crearPersona(String dni, String login) {
		final Persona persona = new Persona();
		persona.setNombre("Miguel");
		persona.setApellidos("Sanchez Torrijo");
		persona.setEdad(20);
		persona.setEstadoCivil(EstadoCivil.SOLTERO);
		persona.setDni(dni);
		persona.setFechaAlta(new Date());
		persona.setLogin(login);
		persona.setPassword("sa");

		final Direccion direccion1 = new Direccion();
		direccion1.setProvincia("Sevilla");
		direccion1.setCiudad("Ecija");
		direccion1.setCodigoPostal("41439");
		direccion1.setCalle("Alemania");
		direccion1.setNumero(18);

		final Direccion direccion2 = new Direccion();
		direccion2.setProvincia("Sevilla");
		direccion2.setCiudad("Cañada");
		direccion2.setCodigoPostal("41439");
		direccion2.setCalle("Alemania");
		direccion2.setNumero(18);

		final Telefono telefono1 = new Telefono();
		telefono1.setNumero("668203497");

		final Telefono telefono2 = new Telefono();
		telefono2.setNumero("668203498");

		persona.agregarDireccion(direccion1);
		persona.agregarDireccion(direccion2);
		persona.agregarTelefono(telefono1);
		persona.agregarTelefono(telefono2);

		return RepositorioPersona.crearPersona(persona);
	}

	private static Integer crearCliente(String dni, String login) {
		final Cliente cliente = new Cliente();
		cliente.setNombre("Miguel");
		cliente.setApellidos("Sanchez Torrijo");
		cliente.setEdad(20);
		cliente.setEstadoCivil(EstadoCivil.SOLTERO);
		cliente.setDni(dni);
		cliente.setFechaAlta(new Date());
		cliente.setLogin(login);
		cliente.setPassword("sa");

		return RepositorioCliente.crearCliente(cliente);
	}

	private static void modificarPersona() {
		final Persona persona = new Persona();
		persona.setIdUsuario(1);
		persona.setNombre("Miguel1");
		persona.setApellidos("Sanchez Torrijo");
		persona.setEdad(20);
		persona.setEstadoCivil(EstadoCivil.SOLTERO);
		persona.setDni("61111111A");
		persona.setFechaAlta(new Date());
		persona.setLogin("sa6");
		persona.setPassword("sa");

		final Direccion direccion3 = new Direccion();
		direccion3.setProvincia("Sevilla");
		direccion3.setCiudad("Palma");
		direccion3.setCodigoPostal("41439");
		direccion3.setCalle("Alemania");
		direccion3.setNumero(18);

		final Telefono telefono3 = new Telefono();
		telefono3.setNumero("668203491");

		persona.agregarDireccion(direccion3);
		persona.agregarTelefono(telefono3);

		RepositorioPersona.modificarPersona(persona);
	}

	private static void eliminarPersona(Integer idUsuario) {
		RepositorioPersona.eliminarPersona(idUsuario);
	}

	private static void consultarPersona(String nombre, String apellidos, String dni, EstadoCivil estadoCivil,
			String login) {
		final List<Persona> lista = RepositorioPersona.consultar(nombre, apellidos, dni, estadoCivil, login);

		System.out.println(lista.size());
	}

	private static void modificarCliente() {
		final Cliente cliente = new Cliente();
		cliente.setIdUsuario(3);
		cliente.setNombre("Miguel1");
		cliente.setApellidos("Sanchez Torrijo");
		cliente.setEdad(20);
		cliente.setEstadoCivil(EstadoCivil.SOLTERO);
		cliente.setDni("52222222B");
		cliente.setFechaAlta(new Date());
		cliente.setLogin("sa5");
		cliente.setPassword("sa");

		RepositorioCliente.modificarCliente(cliente);
	}

	private static void eliminarCliente(Integer idUsuario) {
		RepositorioCliente.eliminarPersona(idUsuario);
	}

	private static void consultarCliente(String nombre, String apellidos, String dni, EstadoCivil estadoCivil) {
		final List<Cliente> lista = RepositorioCliente.consultar(nombre, apellidos, dni, estadoCivil);

		System.out.println(lista.size());
	}
}
