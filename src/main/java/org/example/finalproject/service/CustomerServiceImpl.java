package org.example.finalproject.service;

import org.example.finalproject.model.Customer;
import org.example.finalproject.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CustomerServiceImpl implements CustomerService{

    @Autowired
    private CustomerRepository customerRepository;

    @Override
    public Customer save(Customer customer){
        return customerRepository.save(customer);
    }

    @Override
    public Optional<Customer> findCustomer(Integer id){
        return customerRepository.findById(id);
    }

    @Override
    public List<Customer> findAll() {
        return customerRepository.findAll();
    }

    @Override
    public Customer update(Customer customer){
        return customerRepository.save(customer);
    }

    @Override
    public void delete(Integer customerId){
        customerRepository.deleteById(customerId);
    }
}
