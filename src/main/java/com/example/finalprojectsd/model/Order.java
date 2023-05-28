package com.example.finalprojectsd.model;


import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="orders")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_order")
    private Long id_order;

    @Column (name="table_number",nullable = false,length = 20)
    private int tableNumber;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "waiter_id")
    private User waiter;

    public Order(Long id_order, int tableNumber, User user, User waiter) {
        this.id_order = id_order;
        this.tableNumber = tableNumber;
        this.user = user;
        this.waiter = waiter;
    }

    public Order(int tableNumber, User user, User waiter) {
        this.tableNumber = tableNumber;
        this.user = user;
        this.waiter = waiter;
    }

    public Order() {
    }

    public Long getId_order() {
        return id_order;
    }

    public void setId_order(Long id_order) {
        this.id_order = id_order;
    }

    public int getTableNumber() {
        return tableNumber;
    }

    public void setTableNumber(int tableNumber) {
        this.tableNumber = tableNumber;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public User getWaiter() {
        return waiter;
    }

    public void setWaiter(User waiter) {
        this.waiter = waiter;
    }
}
