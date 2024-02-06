//package org.example.finalproject;
//
//import org.example.finalproject.model.Customer;
//import org.example.finalproject.model.Orders;
//import org.example.finalproject.model.Product;
//import org.example.finalproject.service.CustomerService;
//import org.example.finalproject.service.OrdersService;
//import org.example.finalproject.service.ProductService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.ApplicationArguments;
//import org.springframework.boot.ApplicationRunner;
//import org.springframework.stereotype.Service;
//
//import java.util.ArrayList;
//import java.util.Arrays;
//import java.util.List;
//
//@Service
//public class Test implements ApplicationRunner {
//    @Autowired
//    OrdersService ordersService;
//
//    @Autowired
//    ProductService productService;
//
//    @Autowired
//    CustomerService customerService;
//
//    @Override
//    public void run(ApplicationArguments args) throws Exception {
//        Product product = productService.findProduct(5).get();
//        Product product1 = productService.findProduct(6).get();
//        Customer customer = customerService.findCustomer(4).get();
//        Orders orders = new Orders();
//        orders.setOrdersStaffId(111);
//        orders.setOrdersDate("121212");
//        orders.setCustomer(customer);
//        List<Product> products = new ArrayList<>();
//        products.add(product);
//        products.add(product1);
//        orders.setProducts(products);
//
//        ordersService.save(orders);
//    }
//}
