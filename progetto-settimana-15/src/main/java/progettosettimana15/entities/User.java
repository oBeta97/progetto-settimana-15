package progettosettimana15.entities;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "users")
public class User {

    @Id
    @Column(name = "card_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long cardId;
    private String name;
    private String surname;
    private LocalDate birthday;

    public User(){};

    public User(long cardId, String name, String surname, LocalDate birthday) {
        this.cardId = cardId;
        this.name = name;
        this.surname = surname;
        this.birthday = birthday;
    }

    public long getCardId() {
        return cardId;
    }

    private void setCardId(long cardId) {
        this.cardId = cardId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public LocalDate getBirthday() {
        return birthday;
    }

    public void setBirthday(LocalDate birthday) {
        this.birthday = birthday;
    }

    @Override
    public String toString() {
        return "User{" +
                "cardId=" + cardId +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", birthday=" + birthday +
                '}';
    }
}
