package org.example.finalproject.service;

import org.example.finalproject.model.Product;
import org.example.finalproject.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductRepository productRepository;

    @Override
    public Product save(Product product){
        return productRepository.save(product);
    }
    @Override
    public Optional<Product> findProduct(Integer id){
        return productRepository.findById(id);
    }
    @Override
    public List<Product> findAll() {
        return productRepository.findAll();
    }
    @Override
    public Product update(Product product){
        return productRepository.save(product);
    }
    @Override
    public void delete(Integer productId){
        Product product = productRepository.findById(productId).get();
        productRepository.delete(product);
    }
}
