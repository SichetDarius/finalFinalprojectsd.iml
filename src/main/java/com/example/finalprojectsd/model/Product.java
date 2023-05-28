package com.example.finalprojectsd.model;


import javax.persistence.*;

@Entity
@Table(name="product")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id_product;
    @Column (name="product_name",nullable = false,length = 20)
    private String productName;
    @Column (name="quantity",nullable = false,length = 20)
    private int quantity;
    @Column(name="product_details",nullable = false,length = 20)
    private String details;
    @Column (name="price",nullable = false,length = 20)
    private int price;

    public Product(){

    }

    public Product(Long id_product, String productName, int quantity, String details, int price) {
        this.id_product = id_product;
        this.productName = productName;
        this.quantity = quantity;
        this.details = details;
        this.price = price;
    }

    public Product(String productName, int quantity, String details, int price) {
        this.productName = productName;
        this.quantity = quantity;
        this.details = details;
        this.price = price;
    }

    public Long getId_product() {
        return id_product;
    }

    public void setId_product(Long id_product) {
        this.id_product = id_product;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}
