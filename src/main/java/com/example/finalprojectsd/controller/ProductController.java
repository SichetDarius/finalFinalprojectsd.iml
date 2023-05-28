package com.example.finalprojectsd.controller;


import com.example.finalprojectsd.model.Product;
import com.example.finalprojectsd.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/products")
@RestController
public class ProductController {
    @Autowired
    private ProductService productService;
    //show show list
    @GetMapping
    public List<Product> getProducts(){
        return productService.getAllProducts();
    }
    //add show
    @PostMapping
    public void addNewProduct(@RequestBody Product product) {
        productService.saveProducts(product);
    }

    //update show
    @GetMapping("/{id}")
    public Product showFormForUpdate(@PathVariable(value = "id") long id){
        Product product = productService.getProductById(id);

        return product;
    }
    //delete show
    @DeleteMapping("/delete/{id}")
    public void deleteProduct(@PathVariable (value = "id") long id){

        //call delete show method
        this.productService.deleteProductById(id);
    }
}

