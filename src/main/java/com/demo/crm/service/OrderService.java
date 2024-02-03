package com.demo.crm.service;

import com.demo.crm.models.Order;
import com.demo.crm.repositories.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OrderService {
    @Autowired
    OrderRepository orderRepository;


    public void add(Order p) {
        orderRepository.save(p);
    }


    public List<Order> getAll() {
        return orderRepository.findAll();
    }


    public Optional<Order> findById(Integer id) {
        return orderRepository.findById(id);
    }


    public void update(Order p) {
        orderRepository.save(p);
    }


    public void delete(Integer id) {
        orderRepository.deleteById(id);
    }
}
