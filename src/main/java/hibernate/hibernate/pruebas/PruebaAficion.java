package hibernate.hibernate.pruebas;

import java.util.List;

import hibernate.hibernate.modelo.Aficion;
import hibernate.hibernate.repositorio.RepositorioAficion;

public class PruebaAficion {

	public static void main(String[] args) {
		consultarAficiones();
		consultarAficiones();
	}

	private static void consultarAficiones() {
		List<Aficion> lista = RepositorioAficion.consultarAficiones();

		lista.stream().map(Aficion::getNombre).forEach(System.out::println);
	}
}
