package com.example.finalprojectsd.controller;

import com.example.finalprojectsd.model.Order;
import com.example.finalprojectsd.model.Product;
import com.example.finalprojectsd.service.OrderService;
import com.example.finalprojectsd.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/orders")
@RestController
public class OrderController {
    @Autowired
    private OrderService orderService;
    @GetMapping
    public List<Order> getOrders(){
        return orderService.getAllOrders();
    }
    @GetMapping("/{id}")
    public Order getOrderById(@PathVariable(value = "id") long id){
        return orderService.getOrderById(id);
    }

    @PostMapping
    public void addOrder(@RequestBody Order order) {
        orderService.saveOrder(order);
    }



    @GetMapping("/finalize/{id}")
    public void finalizeOrder(@PathVariable(value = "id") long id){
        orderService.finalizeOrder(id);
    }
}
