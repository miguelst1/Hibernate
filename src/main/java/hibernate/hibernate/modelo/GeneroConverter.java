package hibernate.hibernate.modelo;

import javax.persistence.AttributeConverter;

public class GeneroConverter implements AttributeConverter<Genero, String> {

	@Override
	public String convertToDatabaseColumn(Genero genero) {
		return genero.getCodigo();
	}

	@Override
	public Genero convertToEntityAttribute(String generoBBDD) {
		return Genero.getEnumerado(generoBBDD);
	}

}
