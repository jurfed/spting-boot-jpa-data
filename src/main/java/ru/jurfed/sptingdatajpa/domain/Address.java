package ru.jurfed.sptingdatajpa.domain;


import javax.persistence.*;

@Entity(name = "Address")
@Table(name = "Address")
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
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
