package org.example.finalproject.service;

import org.example.finalproject.model.Customer;

import java.util.List;
import java.util.Optional;

public interface CustomerService {
    Optional<Customer> findCustomer(Integer customerId);
    List<Customer> findAll();
    Customer save(Customer customer);
    Customer update(Customer customer);
//    void delete(Customer customer);

    void delete(Integer customerId);
}
