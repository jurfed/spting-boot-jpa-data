package ru.jurfed.sptingdatajpa.domain;

import javax.persistence.*;
import java.util.Objects;

@Entity(name = "Email")
@Table(name = "email")
public class Email {

    public Email() {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "mail_id")
    private int id;

    @Column(name = "mail_name")
    private String email;

    public Email(String email) {
        this.email = email;
    }

    public int getId() {
        return id;
    }

    public String getEmail() {
        return email;
    }

    @Override
    public String toString() {
        return "Email{" +
                "id=" + id +
                ", email='" + email + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Email email1 = (Email) o;
        return Objects.equals(email, email1.email);
    }

    @Override
    public int hashCode() {
        return Objects.hash(email);
    }
}
