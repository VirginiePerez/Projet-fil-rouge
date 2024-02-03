package com.demo.crm.controller;

import com.demo.crm.models.Client;
import com.demo.crm.models.Order;
import com.demo.crm.service.ClientService;
import com.demo.crm.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class OrderController {
    @Autowired
    OrderService orderService;

    // POST (Created)
    @PostMapping("orders")
    @ResponseStatus(HttpStatus.CREATED)
    public void add(@RequestBody Order o) {
        orderService.add(o);

    }

    // GET (Read all)
    @GetMapping("orders")
    public List<Order> getList() {
        return orderService.getAll();
    }

    // GET (Read by id)
    @GetMapping("orders/{id}")
    public ResponseEntity<Order> getById(@PathVariable("id") Integer id) {
        Optional<Order> opt = orderService.findById(id);
        if (opt.isEmpty()) {
            return ResponseEntity.notFound().build();
        } else {
            Order order = opt.get();
            return ResponseEntity.ok(order);
        }
    }

    // PUT (Update)
    @PutMapping("orders/{id}")
    public ResponseEntity<Client> update(@RequestBody Order order,
                                         @PathVariable("id") Integer id) {
        if (!order.getId().equals(id)) {
            return ResponseEntity.notFound().build();
        } else {
            orderService.update(order);
            return ResponseEntity.ok().build();
        }
    }

    // DELETE (Delete)
    @DeleteMapping("orders/{id}")
    public ResponseEntity<Order> delete(@PathVariable("id") Integer id) {
        if(orderService.findById(id).isPresent()){
           orderService.delete(id);
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
