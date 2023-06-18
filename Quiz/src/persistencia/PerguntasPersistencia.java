package persistencia;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import entidades.Pergunta;

public class PerguntasPersistencia {
	public static boolean incluir(Pergunta pergunta) {
		try {
			EntityManager manager = EntityManagerFactory.getInstance();
			manager.getTransaction().begin();
			manager.persist(pergunta);
			manager.getTransaction().commit();
			return true;
		} catch (Exception e) {
			return false;
		}
	}
	
	public static List<Pergunta> listarPerguntas() {
        EntityManager manager = EntityManagerFactory.getInstance();
        Query consulta = manager.createQuery("SELECT p FROM Pergunta p");
        List<Pergunta> perguntas = consulta.getResultList();
        return perguntas;
    }
	
	public static boolean alterar(Pergunta pergunta) {
		try {
			EntityManager manager = EntityManagerFactory.getInstance();
			manager.getTransaction().begin();
			manager.persist(pergunta);
			manager.getTransaction().commit();
			return true;

		} catch (Exception e) {
			return false;
		}
	}
	public static Pergunta getPerguntaPorId(int id) {
	    EntityManager manager = EntityManagerFactory.getInstance();
	    return manager.find(Pergunta.class, id);
	}

	public static boolean excluir(Pergunta pergunta) {
		try {
			EntityManager manager = EntityManagerFactory.getInstance();
			manager.getTransaction().begin();
			manager.remove(pergunta);
			manager.getTransaction().commit();
			return true;

		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

}
