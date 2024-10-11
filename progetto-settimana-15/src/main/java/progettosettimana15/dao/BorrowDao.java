package progettosettimana15.dao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import progettosettimana15.entities.Borrow;
import progettosettimana15.entities.Catalog;
import progettosettimana15.exceptions.NotFoundException;

import java.util.List;

public class BorrowDao extends BaseDAO {

    public BorrowDao(EntityManager em) {
        super(em);
    }

    public List<Catalog> getActiveBorrow(long userId) throws NotFoundException {
        TypedQuery<Catalog> q = entityManager.createQuery("SELECT c FROM Catalog c JOIN Borrow b ON b.catalog.isbn = c.isbn WHERE b.endDt > CURRENT_DATE AND b.deliveryDt IS NULL AND b.user.cardId = :user_id ", Catalog.class);
        q.setParameter("user_id", userId);

        return this.executeTypedQuery(Catalog.class, q);
    }

    public List<Borrow> getExpiredBorrows() throws NotFoundException {
        TypedQuery<Borrow> q = entityManager.createNamedQuery("expiredBorrows", Borrow.class);

        return this.executeTypedQuery(Borrow.class, q);
    }

}
