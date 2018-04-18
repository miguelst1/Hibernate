package hibernate.hibernate.repositorio;

import java.util.List;

import org.hibernate.Session;

import hibernate.hibernate.modelo.EstadoCivil;
import hibernate.hibernate.modelo.Persona;
import hibernate.hibernate.util.HibernateUtil;

public class RepositorioPersona {

	public static Integer crearPersona(final Persona persona) {
		final Session sesion = HibernateUtil.getSessionFactory().getCurrentSession();

		try {
			sesion.beginTransaction();

			final Integer idPersona = (Integer) sesion.save(persona);

			sesion.getTransaction().commit();

			return idPersona;
		} catch (Exception e) {
			System.out.println("Se ha producido un error insertando la persona: " + e.getMessage());
			e.printStackTrace();
			throw new RuntimeException();
		} finally {
			sesion.close();
		}
	}

	public static void modificarPersona(final Integer idPersona, final String nombre) {
		final Session sesion = HibernateUtil.getSessionFactory().getCurrentSession();

		try {
			sesion.beginTransaction();

			sesion.createQuery("Update Persona set per_nom = :nombre where per_id = :identificador")
					.setParameter("nombre", nombre).setParameter("identificador", idPersona).executeUpdate();

			sesion.getTransaction().commit();
		} catch (Exception e) {
			System.out.println("Se ha producido un error insertando la persona: " + e.getMessage());
			e.printStackTrace();
			throw new RuntimeException();
		} finally {
			sesion.close();
		}
	}

	public static void modificarPersona2(final Integer idPersona, final String nombre) {
		final Session sesion = HibernateUtil.getSessionFactory().getCurrentSession();

		try {
			sesion.beginTransaction();

			final Persona personaBBDD = (Persona) sesion.createQuery("from Persona wherePER_ID = :idPersona")
					.setParameter("idPersona", idPersona).uniqueResult();

			personaBBDD.setNombre(nombre);

			sesion.getTransaction().commit();
		} catch (Exception e) {
			System.out.println("Se ha producido un error insertando la persona: " + e.getMessage());
			e.printStackTrace();
			throw new RuntimeException();
		} finally {
			sesion.close();
		}
	}

	public static void modificarPersona(Persona persona) {
		final Session sesion = HibernateUtil.getSessionFactory().getCurrentSession();

		try {
			sesion.beginTransaction();

			sesion.saveOrUpdate(persona);

			sesion.getTransaction().commit();
		} catch (Exception e) {
			System.out.println("Se ha producido un error insertando la persona: " + e.getMessage());
			e.printStackTrace();
			throw new RuntimeException();
		} finally {
			sesion.close();
		}
	}

	public static void eliminarPersona(final Integer idPersona) {
		final Session sesion = HibernateUtil.getSessionFactory().getCurrentSession();

		try {
			sesion.beginTransaction();

			sesion.createQuery("Delete Persona where per_id = :identificador").setParameter("identificador", idPersona)
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

	public static Persona consultarPersona(final Integer idPersona) {
		final Session sesion = HibernateUtil.getSessionFactory().getCurrentSession();

		try {
			sesion.beginTransaction();

			return (Persona) sesion.createQuery("from Persona where per_id = :identificador")
					.setParameter("identificador", idPersona).uniqueResult();

		} catch (Exception e) {
			System.out.println("Se ha producido un error insertando la persona: " + e.getMessage());
			e.printStackTrace();
			throw new RuntimeException();
		} finally {
			sesion.close();
		}
	}

	public static List<Persona> consultar(String nombre, String apellidos, String dni, EstadoCivil estadoCivil) {
		final Session sesion = HibernateUtil.getSessionFactory().getCurrentSession();

		try {
			sesion.beginTransaction();

			final StringBuilder sb = new StringBuilder("from Persona where 1 = 1");
			if (!nombre.isEmpty()) {
				sb.append(" and per_nom like :nombre");
			}
			if (!apellidos.isEmpty()) {
				sb.append(" and per_ape like :apellidos");
			}
			if (!dni.isEmpty()) {
				sb.append(" and per_dni = :dni");
			}
			if (estadoCivil != null) {
				sb.append(" and per_ecv = :estadoCivil");
			}

			final org.hibernate.query.Query<Persona> consulta = sesion.createQuery(sb.toString());

			if (!nombre.isEmpty()) {
				consulta.setParameter("nombre", nombre);
			}
			if (!apellidos.isEmpty()) {
				consulta.setParameter("apellidos", apellidos);
			}
			if (!dni.isEmpty()) {
				consulta.setParameter("dni", dni);
			}
			if (estadoCivil != null) {
				consulta.setParameter("estadoCivil", estadoCivil.ordinal());
			}

			return consulta.list();
		} catch (Exception e) {
			System.out.println("Se ha producido un error insertando la persona: " + e.getMessage());
			e.printStackTrace();
			throw new RuntimeException();
		} finally {
			sesion.close();
		}
	}
}
