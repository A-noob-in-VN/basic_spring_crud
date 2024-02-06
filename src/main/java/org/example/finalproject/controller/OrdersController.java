package org.example.finalproject.controller;

import org.example.finalproject.model.Customer;
import org.example.finalproject.model.Orders;
import org.example.finalproject.model.Product;
import org.example.finalproject.model.dto.OrdersDto;
import org.example.finalproject.service.CustomerService;
import org.example.finalproject.service.OrdersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("v1/shopee/orders")
public class OrdersController {

    @Autowired
    private OrdersService ordersService;

    @Autowired
    private CustomerService customerService;

    @GetMapping("getAll")
    public String getIndex(){
        return "orders";
    }

    @GetMapping("{orders_id}")
    public ResponseEntity<Orders> findOrders(@PathVariable Integer orders_id){
        Optional<Orders> ordersOptional = ordersService.findOrders(orders_id);
        return ordersOptional.map(ResponseEntity::ok)
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @GetMapping
    public ResponseEntity<List<Orders>> findAll(){
        List<Orders> rs = ordersService.findAll();

        return ResponseEntity.ok(ordersService.findAll());
    }

    @PostMapping
    public ResponseEntity<Orders> save(@RequestBody OrdersDto ordersDto){
        Orders orders = new Orders(ordersDto.getOrdersDate(),
                ordersDto.getOrdersStaffId());
        Optional<Customer> customer = customerService.findCustomer(ordersDto.getCustomerId());
        if(customer.isPresent()) {
            Customer customer1 = customer.get();
            orders.setCustomer(customer1);
        }
        return ResponseEntity.ok(ordersService.save(orders));
    }

    @PutMapping("/{orders_id}")
    public ResponseEntity<Orders> update(@PathVariable Integer orders_id, @RequestBody Orders orders){
        orders.setOrdersId(orders_id);
        return ResponseEntity.ok(ordersService.update(orders));
    }

    @DeleteMapping("/{orders_id}")
    public void delete(@PathVariable Integer orders_id) {
        ordersService.delete(orders_id);
    }
}
