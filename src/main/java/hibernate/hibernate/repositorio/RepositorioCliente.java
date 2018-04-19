package hibernate.hibernate.repositorio;

import java.util.List;

import org.hibernate.Session;

import hibernate.hibernate.modelo.Cliente;
import hibernate.hibernate.modelo.EstadoCivil;
import hibernate.hibernate.util.HibernateUtil;

public class RepositorioCliente {

	public static Integer crearCliente(final Cliente cliente) {
		final Session sesion = HibernateUtil.getSessionFactory().getCurrentSession();

		try {
			sesion.beginTransaction();

			final Integer idPersona = (Integer) sesion.save(cliente);

			sesion.getTransaction().commit();

			return idPersona;
		} catch (Exception e) {
			System.out.println("Se ha producido un error insertando el cliente: " + e.getMessage());
			e.printStackTrace();
			throw new RuntimeException();
		} finally {
			sesion.close();
		}
	}

	public static void modificarCliente(Cliente cliente) {
		final Session sesion = HibernateUtil.getSessionFactory().getCurrentSession();

		try {
			sesion.beginTransaction();

			sesion.saveOrUpdate(cliente);

			sesion.getTransaction().commit();
		} catch (Exception e) {
			System.out.println("Se ha producido un error insertando el cliente: " + e.getMessage());
			e.printStackTrace();
			throw new RuntimeException();
		} finally {
			sesion.close();
		}
	}

	public static void eliminarPersona(final Integer idUsuario) {
		final Session sesion = HibernateUtil.getSessionFactory().getCurrentSession();

		try {
			sesion.beginTransaction();

			sesion.createQuery("Delete Usuario where usu_id = :identificador").setParameter("identificador", idUsuario)
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

	public static List<Cliente> consultar(String nombre, String apellidos, String dni, EstadoCivil estadoCivil) {
		final Session sesion = HibernateUtil.getSessionFactory().getCurrentSession();

		try {
			sesion.beginTransaction();

			final StringBuilder sb = new StringBuilder("from Cliente where 1 = 1");
			if (!nombre.isEmpty()) {
				sb.append(" and cli_nom like :nombre");
			}
			if (!apellidos.isEmpty()) {
				sb.append(" and cli_ape like :apellidos");
			}
			if (!dni.isEmpty()) {
				sb.append(" and cli_dni = :dni");
			}
			if (estadoCivil != null) {
				sb.append(" and cli_ecv = :estadoCivil");
			}

			final org.hibernate.query.Query<Cliente> consulta = sesion.createQuery(sb.toString());

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
