package com.example.finalprojectsd.service;

import com.example.finalprojectsd.model.ProductOrder;
import com.example.finalprojectsd.repository.ProductOrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductOrderService {
    @Autowired
    private ProductOrderRepository ProductOrderRepository;
    
    public List<ProductOrder> getAllProductOrders() {
        return ProductOrderRepository.findAll();
    }
    
    public void saveProductOrders(ProductOrder ProductOrder) {
        this.ProductOrderRepository.save(ProductOrder);
    }

    public ProductOrder getProductOrderById(Integer id) {
        Optional<ProductOrder> optional = ProductOrderRepository.findById(id);
        ProductOrder ProductOrder=null;
        if(optional.isPresent()){
            ProductOrder=optional.get();
        }else{
            throw new RuntimeException("Show is not found for id::"+id);
        }
        return ProductOrder;
    }

    public void deleteProductOrderById(Integer id) {
        this.ProductOrderRepository.deleteById(id);
    }
}
