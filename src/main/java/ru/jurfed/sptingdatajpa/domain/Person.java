package ru.jurfed.sptingdatajpa.domain;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity(name = "Person")
@Table(name = "Person")
public class Person {

    public Person(String name, String surname, Address address) {
        this.name = name;
        this.surname = surname;
        this.address = address;
    }

    public Person(int id, String name, String surname) {
        this.id = id;
        this.surname = surname;
        this.address = address;
    }


    public Person(String name, String surname) {
        this.name = name;
        this.surname = surname;
    }

    public Person() {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "person_id")
    private int id;

    @Column(name = "person_name")
    private String name;

    @Column(name = "person_surname")
    private String surname;


    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "addressid", referencedColumnName = "addr_id")
    private Address address;

    @OneToMany(
            cascade = {CascadeType.ALL}, fetch = FetchType.EAGER
    )
    @JoinColumn(name = "mail_person", referencedColumnName = "person_id")
    private List<Email> emails = new ArrayList<>();

    public Person(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public List<Email> getEmails() {
        return emails;
    }

    public void setEmails(List<Email> emails) {
        this.emails = emails;
    }

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", address=" + address +
                ", emails=" + emails +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return Objects.equals(name, person.name) &&
                Objects.equals(surname, person.surname) &&
                Objects.equals(address, person.address);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, surname, address);
    }
}
