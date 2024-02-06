package org.example.finalproject.service;

import org.example.finalproject.model.Product;

import java.util.List;
import java.util.Optional;

public interface ProductService {
    Optional<Product> findProduct(Integer productId);
    List<Product> findAll();
    Product save(Product product);
    Product update(Product product);
//    void delete(Product product);

    void delete(Integer productId);
}