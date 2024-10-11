package progettosettimana15;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import progettosettimana15.dao.BaseDAO;
import progettosettimana15.dao.CatalogDAO;
import progettosettimana15.entities.Book;
import progettosettimana15.entities.Magazine;
import progettosettimana15.enums.BookGenre;
import progettosettimana15.enums.MagazinePeriodicity;
import com.github.javafaker.Faker;

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
        BaseDAO bd = new BaseDAO(em);
        CatalogDAO cd = new CatalogDAO(em);


        Book randomBook = new Book(f.number().numberBetween(50,300), LocalDate.now(),f.book().title(), UUID.randomUUID(), f.funnyName().name(), BookGenre.FANTASY );
        Magazine randomMag = new Magazine(f.number().numberBetween(10,30),LocalDate.now(), f.animal().name(), UUID.randomUUID(), MagazinePeriodicity.WEEKLY);

        bd.save(randomBook);
        bd.save(randomMag);

        try {
            bd.delete(Book.class, "003a0af9-870b-4b75-9922-64ecb75f4a42");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        List<Book> books2024 = cd.findCatalogByPublicationDt(Book.class, LocalDate.now());
        for(Book b : books2024) System.out.println(b);

        List<Book> meBook = cd.findCatalogByAuthor(Book.class, "ME");
        for(Book b : meBook) System.out.println(b);


        System.out.println("END! :(");

    }
}
