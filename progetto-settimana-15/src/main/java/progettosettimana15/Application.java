package progettosettimana15;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import progettosettimana15.dao.BaseDAO;
import progettosettimana15.dao.BorrowDao;
import progettosettimana15.dao.CatalogDAO;
import progettosettimana15.entities.*;
import progettosettimana15.enums.BookGenre;
import progettosettimana15.enums.MagazinePeriodicity;
import com.github.javafaker.Faker;
import progettosettimana15.exceptions.NotFoundException;

import java.time.LocalDate;
import java.util.List;
import java.util.Locale;
import java.util.UUID;

public class Application {
    private static final EntityManagerFactory progettoSettimana15Factory = Persistence.createEntityManagerFactory("progettosettimana15");

    public static void main(String[] args) {
        System.out.println("Hello World!");

        EntityManager em = progettoSettimana15Factory.createEntityManager();

        Faker f = new Faker(Locale.ITALY);
        CatalogDAO cd = new CatalogDAO(em);
        BorrowDao bd = new BorrowDao(em);


        Book randomBook = new Book(f.number().numberBetween(50,300), LocalDate.now(),f.book().title(), UUID.randomUUID(), f.funnyName().name(), BookGenre.FANTASY );
        Book meRandomBook = new Book(f.number().numberBetween(50,300), LocalDate.now(),f.book().title(), UUID.randomUUID(), "ME", BookGenre.FANTASY );
        Magazine randomMag = new Magazine(f.number().numberBetween(10,30),LocalDate.now(), f.animal().name(), UUID.randomUUID(), MagazinePeriodicity.WEEKLY);

        cd.save(randomBook);
        cd.save(meRandomBook);
        cd.save(randomMag);

        try {
            cd.delete(Book.class, "003a0af9-870b-4b75-9922-64ecb75f4a42");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        try {
            List<Book> books2024 = cd.findCatalogByPublicationDt(Book.class, LocalDate.now());
            for (Book b : books2024) System.out.println(b);
        } catch (NotFoundException e) {
            System.out.println(e.getMessage());
        }

        try {
            List<Book> meBook = cd.findCatalogByAuthor(Book.class, "ME");
            for (Book b : meBook) System.out.println(b);
        } catch (NotFoundException e) {
            System.out.println(e.getMessage());
        }

        try {
            List<Magazine> asdMagazine = cd.findCatalogByTitle(Magazine.class, "ASD");
            for (Magazine m : asdMagazine) System.out.println(m);
        } catch (NotFoundException e) {
            System.out.println(e.getMessage());
        }


        User randomUser = new User((long) 0, f.lordOfTheRings().character(), f.backToTheFuture().character(), LocalDate.now().minusYears(f.number().numberBetween(18, 99)));

        cd.save(randomUser);

        try {

            User u = cd.getObjectById(User.class, 2);
            Book b = cd.getObjectById(Book.class, "455a6d96-7267-420a-9f98-5762712ba060");

            Borrow randomBorrow = new Borrow(
                    u
                    , b
                    , LocalDate.now().minusYears(f.number().numberBetween(1, 3))
                    , LocalDate.now().minusMonths(2)
                    , null
            );

            cd.save(randomBorrow);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }


        try{
            List<Catalog> activeBorrows = bd.getActiveBorrow(2);
            for(Catalog c : activeBorrows) System.out.println(c);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }


        try{
            List<Borrow> expiredBorrows = bd.getExpiredBorrows();
            for(Borrow b : expiredBorrows) System.out.println(b);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }



        System.out.println("END! :(");

    }
}
