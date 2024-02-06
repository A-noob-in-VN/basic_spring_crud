package org.example.finalproject.controller;

import org.example.finalproject.model.Product;
import org.example.finalproject.model.dto.ProductDto;
import org.example.finalproject.service.ProductService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("v1/shopee/product")
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping("getAll")
    public String getIndex(){
        return "products";
    }

    @GetMapping("{product_id}")
    public ResponseEntity<Product> findProduct(@PathVariable Integer product_id){
        Optional<Product> productOptional = productService.findProduct(product_id);
        return productOptional.map(ResponseEntity::ok)
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @GetMapping
    public ResponseEntity<List<Product>> findAll() {
        return ResponseEntity.ok(productService.findAll());
    }

    @PostMapping
    public ResponseEntity<Product> save(@RequestBody ProductDto productDto){
        Product product = new Product(productDto.getProductName(), productDto.getProductPrice(),
                productDto.getProduceCode(), productDto.getProductMfg(), productDto.getProductBbf(),
                productDto.getProductSite(), productDto.getProductQuantity());
        return ResponseEntity.ok(productService.save(product));
    }

    @PutMapping("{product_id}")
    public ResponseEntity<Product> update(@PathVariable Integer product_id, @RequestBody ProductDto productDto){
        productDto.setProductId(product_id);
        Product product = new Product();
        BeanUtils.copyProperties(productDto, product);
        return ResponseEntity.ok(productService.update(product));
    }

    @DeleteMapping("{product_id}")
    public void delete(@PathVariable Integer product_id){
        productService.delete(product_id);
    }
}
