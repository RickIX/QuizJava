package persistencia;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import entidades.User;

public class UserPersistencia {
	public static boolean incluir(User user) {
		try {
			EntityManager manager = EntityManagerFactory.getInstance();
			manager.getTransaction().begin();
			manager.persist(user);
			manager.getTransaction().commit();
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	public static boolean alterar(User user) {
		try {
			EntityManager manager = EntityManagerFactory.getInstance();
			manager.getTransaction().begin();
			manager.persist(user);
			manager.getTransaction().commit();
			return true;

		} catch (Exception e) {
			return false;
		}
	}

	public static boolean excluir(User user) {
		try {
			EntityManager manager = EntityManagerFactory.getInstance();
			manager.getTransaction().begin();
			manager.remove(user);
			manager.getTransaction().commit();
			return true;

		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	public static List<User> getUsuarios() {
	    EntityManager manager = EntityManagerFactory.getInstance();
	    Query consulta = manager.createQuery("SELECT u FROM User u");
	    List<User> usuarios = consulta.getResultList();
	    return usuarios;
	}

	
	public static User getUsuarioPorId(int id) {
	    EntityManager manager = EntityManagerFactory.getInstance();
	    return manager.find(User.class, id);
	}
	
	public static User encontrarPorNome(String nome) {
	    EntityManager manager = EntityManagerFactory.getInstance();

	    try {
	        Query query = manager.createQuery("SELECT u FROM User u WHERE u.nome = :nome");
	        query.setParameter("nome", nome);
	        List<User> usuarios = query.getResultList();
	        if (!usuarios.isEmpty()) {
	            return usuarios.get(0);
	        }
	    } catch (Exception e) {
	    }

	    return null;
	}
	
	public static User login(String nome, String senha) {
	    EntityManager manager = EntityManagerFactory.getInstance();

	    try {
	        Query query = manager.createQuery("SELECT u FROM User u WHERE u.nome = :nome and u.senha = :senha");
	        query.setParameter("nome", nome);
	        query.setParameter("senha", senha);
	        List<User> usuarios = query.getResultList();
	        if (!usuarios.isEmpty()) {
	            return usuarios.get(0);
	        }
	    } catch (Exception e) {
	    }

	    return null;
	}
	/*public static List<User> listarUsuariosPorPontuacao() {
	    EntityManager em = PersistenceManager.getEntityManager();
	    try {
	        CriteriaBuilder cb = em.getCriteriaBuilder();
	        CriteriaQuery<User> query = cb.createQuery(User.class);
	        Root<User> root = query.from(User.class);
	        query.orderBy(cb.desc(root.get("pontos")));
	        return em.createQuery(query).getResultList();
	    } finally {
	        em.close();
	    }
	}*/


}