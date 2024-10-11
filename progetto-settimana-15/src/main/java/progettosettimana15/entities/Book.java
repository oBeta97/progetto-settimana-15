package progettosettimana15.entities;

import jakarta.persistence.*;
import progettosettimana15.enums.BookGenre;

import java.time.LocalDate;
import java.util.UUID;

@Entity
@Table(name = "books")
public class Book extends Catalog{


    private String author;
    @Enumerated(EnumType.STRING)
    private BookGenre genre;

    public Book() {}

    public Book(int pages, LocalDate publicationDt, String title, UUID isbn, String author, BookGenre genre) {
        super(pages, publicationDt, title, isbn);
        this.author = author;
        this.genre = genre;
    }


    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public BookGenre getGenre() {
        return genre;
    }

    public void setGenre(BookGenre genre) {
        this.genre = genre;
    }

    @Override
    public String toString() {
        return super.toString() + "Book{" +
                ", author='" + author + '\'' +
                ", genre=" + genre +
                '}';
    }
}
