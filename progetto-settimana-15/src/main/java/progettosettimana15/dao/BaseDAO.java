package progettosettimana15.dao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;

import java.util.UUID;

public class BaseDAO {

    private final EntityManager entityManager;

    public BaseDAO(EntityManager em){
        this.entityManager = em;
    }

    public <T> void save(T obj){
        EntityTransaction t = entityManager.getTransaction();

        t.begin();

        entityManager.persist(obj);

        t.commit();

        System.out.println(obj + " Saved!");
    }


    public <T> T getObjectById(Class<T> entityClass, String id) throws Exception {

        T found = entityManager.find(entityClass, UUID.fromString(id));
        if (found == null) throw new Exception("Evento non trovato");

        return found;
    }


    public <T> void delete (Class<T> entityClass, String  id) throws Exception {
        T obj = this.getObjectById(entityClass, id);

        EntityTransaction t = entityManager.getTransaction();

        t.begin();

        entityManager.remove(obj);

        t.commit();

        System.out.println(obj + " Deleted!");

    }

}
