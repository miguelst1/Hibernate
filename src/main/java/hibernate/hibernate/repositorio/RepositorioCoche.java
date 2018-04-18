package hibernate.hibernate.repositorio;

import org.hibernate.Session;

import hibernate.hibernate.modelo.Coche;
import hibernate.hibernate.util.HibernateUtil;

public class RepositorioCoche {

	public static Integer crearCoche(final Coche coche) {
		final Session sesion = HibernateUtil.getSessionFactory().getCurrentSession();

		try {
			sesion.beginTransaction();

			final Integer idCoche = (Integer) sesion.save(coche);

			sesion.getTransaction().commit();

			return idCoche;
		} catch (Exception e) {
			System.out.println("Se ha producido un error insertando el coche: " + e.getMessage());
			e.printStackTrace();
			throw new RuntimeException();
		} finally {
			sesion.close();
		}
	}

	public static void modificarCoche(final int idCoche, final String matricula) {
		final Session sesion = HibernateUtil.getSessionFactory().getCurrentSession();

		try {
			sesion.beginTransaction();

			sesion.createQuery("Update Coche set coc_mat = :matricula where coc_id = :identificador")
					.setParameter("matricula", matricula).setParameter("identificador", idCoche).executeUpdate();

			sesion.getTransaction().commit();
		} catch (Exception e) {
			System.out.println("Se ha producido un error insertando la persona: " + e.getMessage());
			e.printStackTrace();
			throw new RuntimeException();
		} finally {
			sesion.close();
		}
	}

	public static void eliminarCoche(final int idCoche) {
		final Session sesion = HibernateUtil.getSessionFactory().getCurrentSession();

		try {
			sesion.beginTransaction();

			sesion.createQuery("Delete Coche where coc_id = :identificador").setParameter("identificador", idCoche)
					.executeUpdate();

			sesion.getTransaction().commit();
		} catch (Exception e) {
			System.out.println("Se ha producido un error insertando la persona: " + e.getMessage());
			e.printStackTrace();
			throw new RuntimeException();
		} finally {
			sesion.close();
		}
	}
}
