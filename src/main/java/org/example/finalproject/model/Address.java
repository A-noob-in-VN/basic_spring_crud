package org.example.finalproject.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.*;

import java.util.Collection;

@Data
@Table(name = "address")
@Entity
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    @Column(name = "address_id")
    private Integer addressId;

    @Column(name = "address_name")
    private String addressName;

    @Column(name = "address_city")
    private String addressCity;

    @OneToMany(mappedBy = "address", cascade = CascadeType.ALL)
    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    @JsonBackReference
    private Collection<Customer> customers;

    public Address() {
    }

    public Address(String addressName, String addressCity) {
        this.addressName = addressName;
        this.addressCity = addressCity;
    }
}