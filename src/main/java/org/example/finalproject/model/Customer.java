package org.example.finalproject.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.*;

import java.util.Collection;



@Data
@Table(name = "customer")
@Entity
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    @Column(name = "customer_id")
    private Integer customerId;

    @Column(name = "customer_name")
    private String customerName;

    @Column(name = "customer_age")
    private Integer customerAge;

    @Column(name = "customer_phone_number")
    private String customerPhoneNumber;

    @Column(name = "customer_email")
    private String customerEmail;

    @Column(name = "customer_dob")
    private String customerDoB;


    @Getter
    @ManyToOne
    @JoinColumn(name = "customer_address_id", nullable = false)
    @EqualsAndHashCode.Exclude
    @JsonManagedReference
    @ToString.Exclude
    private Address address;

    @OneToMany(mappedBy = "customer", cascade = CascadeType.ALL)
    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    @JsonBackReference
    private Collection<Orders> orders;

    public Customer() {
    }

    public Customer(String customerName, Integer customerAge, String customerPhoneNumber,
                    String customerEmail, String customerDoB ){
        this.customerName = customerName;
        this.customerAge = customerAge;
        this.customerPhoneNumber = customerPhoneNumber;
        this.customerEmail = customerEmail;
        this.customerDoB = customerDoB;
    }
}
