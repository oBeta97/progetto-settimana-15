package progettosettimana15.dao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import progettosettimana15.entities.Borrow;
import progettosettimana15.exceptions.NotFoundException;

import java.util.List;

public class BorrowDao extends BaseDAO {

    public BorrowDao(EntityManager em) {
        super(em);
    }

    public List<Borrow> getActiveBorrow(long userId) throws NotFoundException {
        TypedQuery<Borrow> q = entityManager.createQuery("SELECT b FROM Borrow b WHERE b.endDt > CURRENT_DATE AND b.deliveryDt IS NULL AND b.user.cardId = :user_id ", Borrow.class);
        q.setParameter("user_id", userId);

        return this.executeTypedQuery(Borrow.class, q);
    }

}
