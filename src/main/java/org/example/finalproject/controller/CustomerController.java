package org.example.finalproject.controller;

import org.example.finalproject.model.Address;
import org.example.finalproject.model.Customer;
import org.example.finalproject.model.dto.CustomerDto;
import org.example.finalproject.service.AddressService;
import org.example.finalproject.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("v1/shopee/customer")
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @Autowired
    private AddressService addressService;

    @GetMapping("getAll")
    public String getIndex() {
        return "customer";
    }

    @GetMapping("{customer_id}")
    public ResponseEntity<Customer> findCustomer(@PathVariable Integer customer_id){
        Optional<Customer> customerOptional = customerService.findCustomer(customer_id);
        return customerOptional.map(ResponseEntity::ok)
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @GetMapping
    public ResponseEntity<List<Customer>> findAll(){
        return ResponseEntity.ok(customerService.findAll());
    }

    @PostMapping
    public ResponseEntity<Customer> save(@RequestBody CustomerDto customerDto) {
        Customer customer = new Customer(customerDto.getCustomerName(), customerDto.getCustomerAge(),
                customerDto.getCustomerPhoneNumber(), customerDto.getCustomerEmail(),
                customerDto.getCustomerDoB());
        Optional<Address> addressOptional = addressService.findAddress(customerDto.getAddressId());
        if(!addressOptional.isPresent()) {
            return ResponseEntity.badRequest().build();
        }
        customer.setAddress(addressOptional.get());
        Customer response = customerService.save(customer);
//        response.setAddress(response.getAddress());
        return ResponseEntity.ok(response);
    }

    @PutMapping("/{customer_id}")
    public ResponseEntity<Customer> update(@PathVariable Integer customer_id, @RequestBody Customer customer){
        customer.setCustomerId(customer_id);
        return ResponseEntity.ok(customerService.update(customer));
    }

    @DeleteMapping("/{customer_id}")
    public void delete(@PathVariable Integer customer_id){
        customerService.delete(customer_id);
    }
}
