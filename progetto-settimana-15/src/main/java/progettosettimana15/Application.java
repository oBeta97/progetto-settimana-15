package progettosettimana15;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import progettosettimana15.dao.BaseDAO;

public class Application {
    private static final EntityManagerFactory progettoSettimana15Factory = Persistence.createEntityManagerFactory("progettosettimana15");

    public static void main(String[] args) {
        System.out.println("Hello World!");

        EntityManager em = progettoSettimana15Factory.createEntityManager();

        BaseDAO bd = new BaseDAO(em);


        System.out.println("END! :(");

    }
}
