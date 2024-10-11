package progettosettimana15.dao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.TypedQuery;
import progettosettimana15.entities.Book;
import progettosettimana15.entities.Catalog;

import java.time.LocalDate;
import java.util.List;

public class CatalogDAO {


    private final EntityManager entityManager;

    public CatalogDAO(EntityManager em){
        this.entityManager = em;
    }


    public <T> List<T> findCatalogByPublicationDt (Class<T> entityType, LocalDate dt){


        TypedQuery<T> q = entityManager.createQuery("SELECT b FROM " + entityType.getSimpleName() + " b WHERE extract(year from b.publicationDt) = :dt", entityType);
        q.setParameter("dt", dt.getYear());

        return q.getResultList();
    }


    public <T> List<T> findCatalogByAuthor(Class<T> entityType, String author){
        TypedQuery<T> q = entityManager.createQuery("SELECT b FROM " + entityType.getSimpleName() + " b WHERE b.author = :author", entityType);
        q.setParameter("author", author);

        return q.getResultList();
    }

}
