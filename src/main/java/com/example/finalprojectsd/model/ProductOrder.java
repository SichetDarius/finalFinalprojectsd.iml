package com.example.finalprojectsd.model;

import javax.persistence.*;

@Entity
@Table(name="product_order")
public class ProductOrder {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id_product_order;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "product_id")
    private Product product;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "order_id")
    private Order order;
    @Column (name="quantity",nullable = false,length = 20)
    private int quantity;

    public ProductOrder(Long id_product_order, Product product, Order order, int quantity) {
        this.id_product_order = id_product_order;
        this.product = product;
        this.order = order;
        this.quantity = quantity;
    }

    public ProductOrder(Product product, Order order, int quantity) {
        this.product = product;
        this.order = order;
        this.quantity = quantity;
    }

    public ProductOrder() {
    }

    public Long getId_product_order() {
        return id_product_order;
    }

    public void setId_product_order(Long id_product_order) {
        this.id_product_order = id_product_order;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
