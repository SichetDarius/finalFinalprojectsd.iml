package com.example.finalprojectsd.controller;


import com.example.finalprojectsd.model.ProductOrder;
import com.example.finalprojectsd.service.ProductOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/productOrders")
@RestController
public class ProductOrderController {
    @Autowired
    private ProductOrderService ProductOrderService;

    @GetMapping
    public List<ProductOrder> getProductOrders(){
        return ProductOrderService.getAllProductOrders();
    }

    @PostMapping
    public void addNewProductOrder(@RequestBody ProductOrder productOrder) {
        ProductOrderService.saveProductOrders(productOrder);
    }

    @GetMapping("/{id}")
    public ProductOrder showFormForUpdate(@PathVariable(value = "id") Integer id){
        ProductOrder ProductOrder = ProductOrderService.getProductOrderById(id);

        return ProductOrder;
    }

    @DeleteMapping("/{id}")
    public void deleteProductOrder(@PathVariable (value = "id") Integer id){

        this.ProductOrderService.deleteProductOrderById(id);
    }
}

