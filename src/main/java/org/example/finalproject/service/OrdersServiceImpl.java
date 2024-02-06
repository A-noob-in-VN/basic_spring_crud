package org.example.finalproject.service;

import org.example.finalproject.model.Orders;
import org.example.finalproject.repository.OrdersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OrdersServiceImpl implements OrdersService {

    @Autowired
    private OrdersRepository ordersRepository;

    @Override
    public Orders save(Orders orders) {
        return ordersRepository.save(orders);
    }

    @Override
    public Optional<Orders> findOrders(Integer id){
        return ordersRepository.findById(id);
    }

    @Override
    public List<Orders> findAll(){
        return ordersRepository.findAll();
    }

    @Override
    public Orders update(Orders orders) {
        return ordersRepository.save(orders);
    }

    @Override
    public void delete(Integer ordersId){
        Orders orders = ordersRepository.findById(ordersId).get();
        ordersRepository.delete(orders);
    }
}
