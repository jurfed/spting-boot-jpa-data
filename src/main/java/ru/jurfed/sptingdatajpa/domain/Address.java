package ru.jurfed.sptingdatajpa.domain;


import javax.persistence.*;

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


    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }



}
