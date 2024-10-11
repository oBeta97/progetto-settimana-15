package progettosettimana15.dao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.TypedQuery;
import progettosettimana15.entities.Book;
import progettosettimana15.entities.Catalog;
import progettosettimana15.exceptions.NotFoundException;

import java.time.LocalDate;
import java.util.List;

public class CatalogDAO extends BaseDAO {

    public CatalogDAO(EntityManager em){
        super(em);
    }

    public <T> List<T> findCatalogByPublicationDt (Class<T> entityType, LocalDate dt) throws NotFoundException {

        TypedQuery<T> q = entityManager.createQuery("SELECT b FROM " + entityType.getSimpleName() + " b WHERE extract(year from b.publicationDt) = :dt", entityType);
        q.setParameter("dt", dt.getYear());

        return this.executeTypedQuery(entityType, q);
    }


    public <T> List<T> findCatalogByAuthor(Class<T> entityType, String author) throws NotFoundException {
        TypedQuery<T> q = entityManager.createQuery("SELECT b FROM " + entityType.getSimpleName() + " b WHERE b.author = :author", entityType);
        q.setParameter("author", author);

        return this.executeTypedQuery(entityType, q);
    }

    public <T> List<T> findCatalogByTitle(Class<T> entityType, String title) throws NotFoundException {
        TypedQuery<T> q = entityManager.createQuery("SELECT b FROM " + entityType.getSimpleName() + " b WHERE b.title like :title", entityType);
        q.setParameter("title", "%"+title+"%");

        return this.executeTypedQuery(entityType, q);
    }

}
