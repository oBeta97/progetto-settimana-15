package progettosettimana15.entities;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.UUID;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@Table(name = "catalogs")
@DiscriminatorColumn(name = "catalog_type")
public abstract class Catalog {

    @Id
    @Column(name = "isbn_id")
    private UUID isbn;
    private String title;
    @Column(name = "publication_date")
    private LocalDate publicationDt;
    private int pages;

    public Catalog() {}

    public Catalog(int pages, LocalDate publicationDt, String title, UUID isbn) {
        this.pages = pages;
        this.publicationDt = publicationDt;
        this.title = title;
        this.isbn = isbn;
    }

    public UUID getIsbn() {
        return isbn;
    }

    protected void setIsbn(UUID isbn) {
        this.isbn = isbn;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public LocalDate getPublicationDt() {
        return publicationDt;
    }

    public void setPublicationDt(LocalDate publicationDt) {
        this.publicationDt = publicationDt;
    }

    public int getPages() {
        return pages;
    }

    public void setPages(int pages) {
        this.pages = pages;
    }
}
