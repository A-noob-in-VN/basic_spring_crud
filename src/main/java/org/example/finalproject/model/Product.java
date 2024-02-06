package org.example.finalproject.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.Data;

import java.util.List;
@Data
@Table(name = "product")
@Entity
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    @Column(name = "product_id")
    private Integer productId;

    @Column(name = "product_name")
    private String productName;

    @Column(name = "product_price")
    private Integer productPrice;

    @Column(name = "produce_code")
    private Integer produceCode;

    @Column(name = "product_mfg_date")
    private String productMfg;

    @Column(name = "product_best_before")
    private String productBbf;

    @Column(name = "product_site")
    private String productSite;

    @Column(name = "product_quantity")
    private Integer productQuantity;

//    @ManyToMany
//    @EqualsAndHashCode.Exclude
    @JsonBackReference
//    @JoinTable(name = "orders_product",
//            inverseJoinColumns = @JoinColumn(name = "orders_id"),
//            joinColumns = @JoinColumn(name = "product_id"))
//    private Set<Orders> orders = new HashSet<>();

    @ManyToMany(mappedBy = "products", cascade = CascadeType.ALL)
    private List<Orders> orders;
    
    public Product() {
    }

    public Product(String productName, Integer productPrice, Integer produceCode,
                   String productMfg, String productBbf, String productSite,
                   Integer productQuantity){
        this.productName = productName;
        this.productPrice = productPrice;
        this.produceCode = produceCode;
        this.productMfg = productMfg;
        this.productBbf = productBbf;
        this.productSite = productSite;
        this.productQuantity = productQuantity;
    }
}
