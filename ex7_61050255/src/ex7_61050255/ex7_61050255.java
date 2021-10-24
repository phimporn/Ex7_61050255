package ex7_61050255;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class ex7_61050255 {

    public static void main(String[] args) {
        
        // INSERT
        FulltimeEmployee emp1 = new FulltimeEmployee();
        emp1.setName("John");
        emp1.setSalary(5000);
        ParttimeEmployee emp2 = new ParttimeEmployee();
        emp2.setName("Jane");
        emp2.setHoursWork(4);
        persist(emp1);
        persist(emp2);
        // UPDATE 
        ParttimeEmployee partemp = new ParttimeEmployee();
        partemp.setId(1);
        partemp.setName("Ohm");
        partemp.setHoursWork(3);
        FulltimeEmployee fullemp = new FulltimeEmployee();
        fullemp.setId(2);
        fullemp.setName("Kham");
        fullemp.setHoursWork(2);
        persist(partemp);        
        persist(fullemp);
        // DELETE 
        remove(2);
        
    }

    public static void remove(int id) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("InheritanceORM22PU");
        EntityManager em = emf.createEntityManager();
        FulltimeEmployee fullem = em.find(FulltimeEmployee.class, id);
        em.getTransaction().begin();
        try {
            em.remove(fullem);
            em.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            em.getTransaction().rollback();
        } finally {
            em.close();
        }
    }

    public static void persist(Object object) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("InheritanceORM22PU");
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        try {
            em.persist(object);
            em.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            em.getTransaction().rollback();
        } finally {
            em.close();
        }
    }

}
