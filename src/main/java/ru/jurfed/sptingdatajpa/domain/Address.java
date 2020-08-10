package ru.jurfed.sptingdatajpa.domain;


import javax.persistence.*;
import java.util.Objects;

@Entity(name = "Address")
@Table(name = "Address")
public class Address {

    public Address() {
    }

    public Address(String address) {
        this.address = address;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "addr_id")
    private int id;

    @Column(name = "street")
    private String address;

    @OneToOne(mappedBy = "address")
    private Person person;

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "Address{" +
                "id=" + id +
                ", address='" + address + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Address address1 = (Address) o;
        return Objects.equals(address, address1.address);
    }

    @Override
    public int hashCode() {
        return Objects.hash(address);
    }
}
