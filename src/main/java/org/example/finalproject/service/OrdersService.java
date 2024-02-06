package org.example.finalproject.service;

import org.example.finalproject.model.Orders;

import java.util.List;
import java.util.Optional;

public interface OrdersService {
    Optional<Orders> findOrders(Integer orderId);
    List<Orders> findAll();
    Orders save(Orders orders);
    Orders update(Orders orders);
//    void delete(Orders orders);
    void delete(Integer ordersId);
}