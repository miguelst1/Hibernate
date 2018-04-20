package hibernate.hibernate.modelo;

import java.util.Arrays;

public enum Genero {

	MASCULINO("M"), FEMENINO("F");

	private String codigo;

	private Genero(String codigo) {
		this.codigo = codigo;
	}

	public String getCodigo() {
		return codigo;
	}

	public static Genero getEnumerado(String valor) {
		return Arrays.asList(values()).stream().filter(genero -> genero.getCodigo().equals(valor)).findAny()
				.orElse(null);
	}
}
