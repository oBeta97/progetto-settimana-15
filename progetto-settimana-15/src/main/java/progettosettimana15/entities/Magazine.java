package progettosettimana15.entities;

import jakarta.persistence.*;
import progettosettimana15.enums.MagazinePeriodicity;

import java.time.LocalDate;
import java.util.UUID;

@Entity
@Table(name = "magazines")
public class Magazine extends Catalog{

    @Enumerated(EnumType.STRING)
    private MagazinePeriodicity periodicity;

    public Magazine() {}

    public Magazine(int pages, LocalDate publicationDt, String title, UUID isbn, MagazinePeriodicity periodicity) {
        super(pages, publicationDt, title, isbn);
        this.periodicity = periodicity;
    }



    public MagazinePeriodicity getPeriodicity() {
        return periodicity;
    }

    public void setPeriodicity(MagazinePeriodicity periodicity) {
        this.periodicity = periodicity;
    }

    @Override
    public String toString() {
        return "Magazine{" +
                ", periodicity=" + periodicity +
                '}';
    }
}
