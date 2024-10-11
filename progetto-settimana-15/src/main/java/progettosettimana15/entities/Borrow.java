package progettosettimana15.entities;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.UUID;

@Entity
@Table(name = "borrows")
public class Borrow {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;
    @ManyToOne
    @JoinColumn(name = "catalog_id", nullable = false)
    private Catalog catalog;
    @Column(name = "start_dt")
    private LocalDate startDt;
    @Column(name = "end_dt")
    private LocalDate endDt;
    @Column(name = "delivery_dt")
    private LocalDate deliveryDt;

    public Borrow() {}

    public Borrow(UUID id, User user, Catalog catalog, LocalDate startDt, LocalDate endDt, LocalDate deliveryDt) {
        this.id = id;
        this.user = user;
        this.catalog = catalog;
        this.startDt = startDt;
        this.endDt = endDt;
        this.deliveryDt = deliveryDt;
    }

    public UUID getId() {
        return id;
    }

    private void setId(UUID id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Catalog getCatalog() {
        return catalog;
    }

    public void setCatalog(Catalog catalog) {
        this.catalog = catalog;
    }

    public LocalDate getStartDt() {
        return startDt;
    }

    public void setStartDt(LocalDate startDt) {
        this.startDt = startDt;
    }

    public LocalDate getEndDt() {
        return endDt;
    }

    public void setEndDt(LocalDate endDt) {
        this.endDt = endDt;
    }

    public LocalDate getDeliveryDt() {
        return deliveryDt;
    }

    public void setDeliveryDt(LocalDate deliveryDt) {
        this.deliveryDt = deliveryDt;
    }

    @Override
    public String toString() {
        return "Borrow{" +
                "id=" + id +
                ", user=" + user +
                ", catalog=" + catalog +
                ", startDt=" + startDt +
                ", endDt=" + endDt +
                ", deliveryDt=" + deliveryDt +
                '}';
    }
}
