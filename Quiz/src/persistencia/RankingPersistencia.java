package persistencia;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import entidades.Ranking;

public class RankingPersistencia {
    public static boolean incluir(Ranking ranking) {
        try {
            EntityManager manager = EntityManagerFactory.getInstance();
            manager.getTransaction().begin();
            manager.merge(ranking);
            manager.getTransaction().commit();
            return true;
        } catch (Exception e) {
        	e.printStackTrace();
            throw e;
        }
    }

    public static List<Ranking> listarRankings() {
        EntityManager manager = EntityManagerFactory.getInstance();
        Query consulta = manager.createQuery("SELECT r FROM Ranking r ORDER BY r.pontuacao DESC");
        List<Ranking> rankings = consulta.getResultList();
        return rankings;
    }

    public static boolean alterar(Ranking ranking) {
        try {
            EntityManager manager = EntityManagerFactory.getInstance();
            manager.getTransaction().begin();
            manager.merge(ranking);
            manager.getTransaction().commit();
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public static Ranking getRankingPorId(int id) {
        EntityManager manager = EntityManagerFactory.getInstance();
        return manager.find(Ranking.class, id);
    }

    public static boolean excluir(Ranking ranking) {
        try {
            EntityManager manager = EntityManagerFactory.getInstance();
            manager.getTransaction().begin();
            manager.remove(ranking);
            manager.getTransaction().commit();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}
