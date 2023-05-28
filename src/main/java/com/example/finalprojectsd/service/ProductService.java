package com.example.finalprojectsd.service;

import com.example.finalprojectsd.model.Product;

import java.util.List;

public interface ProductService {
    List<Product> getAllProducts();
    void saveProducts(Product product);
    Product getProductById(long id);
    void deleteProductById(long id);
}