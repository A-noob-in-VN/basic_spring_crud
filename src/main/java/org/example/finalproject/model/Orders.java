package org.example.finalproject.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.procedure.ProcedureOutputs;

import java.util.Collection;
import java.util.HashSet;
import java.util.List;

@Data
@Table(name = "orders")
@Entity
public class Orders {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    @Column(name = "orders_id")
    private Integer ordersId;

    @Column(name = "orders_date")
    private String ordersDate;

    @Column(name = "orders_staff_id")
    private Integer ordersStaffId;

    @ManyToOne
    @JoinColumn(name = "orders_customer_id")
    @EqualsAndHashCode.Exclude
    @JsonManagedReference
    @ToString.Exclude
    private Customer customer;



    @ManyToMany(fetch = FetchType.EAGER)
    @JsonManagedReference
    @JoinTable(name = "orders_product",
            joinColumns = @JoinColumn(name = "orders_id"),
            inverseJoinColumns = @JoinColumn(name = "product_id")
    )
    private List<Product> products;



    public Orders() {
    }

    public Orders(String ordersDate, Integer ordersStaffId) {

        this.ordersDate = ordersDate;
        this.ordersStaffId = ordersStaffId;
    }
}


