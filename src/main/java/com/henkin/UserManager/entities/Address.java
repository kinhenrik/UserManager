package com.henkin.UserManager.entities;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class Address {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "street", length = 50, nullable = false)
    private String street;

    @Column(name = "postal_code", length = 20, nullable = false)
    private String postalCode;

    @Column(name = "city", length = 50, nullable = false)
    private String city;

    @OneToMany(mappedBy = "address", cascade = CascadeType.ALL)
    private List<Member> memberList;

    public Address() {}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public List<Member> getMemberList() {
        return memberList;
    }

    public void setMemberList(List<Member> memberList) {
        this.memberList = memberList;
    }

    @Override
    public String toString() {
        return "Address{" +
                "id=" + id +
                ", street='" + street + '\'' +
                ", postalCode=" + postalCode +
                ", city='" + city + '\'' +
                ", memberList=" + memberList +
                '}';
    }
}
