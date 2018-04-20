package hibernate.hibernate.repositorio;

import java.util.List;

import org.hibernate.Session;

import hibernate.hibernate.modelo.Aficion;
import hibernate.hibernate.util.HibernateUtil;

public class RepositorioAficion {

	public static List<Aficion> consultarAficiones() {
		final Session sesion = HibernateUtil.getSessionFactory().getCurrentSession();

		try {
			sesion.beginTransaction();

			return sesion.createQuery("from Aficion").setCacheable(true).list();

		} catch (Exception e) {
			System.out.println("Se ha producido un error insertando la persona: " + e.getMessage());
			e.printStackTrace();
			throw new RuntimeException();
		} finally {
			sesion.close();
		}
	}
}
