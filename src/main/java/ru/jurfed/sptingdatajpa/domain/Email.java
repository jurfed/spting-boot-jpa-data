package ru.jurfed.sptingdatajpa.domain;

import javax.persistence.*;

@Entity(name = "Email")
@Table(name = "email")
public class Email {

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
}
