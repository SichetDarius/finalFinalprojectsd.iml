package com.example.finalprojectsd.model;


import javax.persistence.*;

@Entity
@Table(name="users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id_user;
    @Column (name="username",nullable = false,length = 20)
    private String username;
    @Column (name="nume",nullable = false,length = 20)
    private String nume;
    @Column(name="prenume",nullable = false,length = 20)
    private String prenume;
    @Column(nullable = false,unique = true,length = 45)
    private String email;
    @Column(length = 500)
    private String password;
    @Column(name = "role", length = 20)
    private String role;
    @Column(name = "no_of_orders")
    private Integer noOfOrders;
    @Column(name = "total_sum_ordered")
    private Integer totalSum;



    public User() {
    }

    public User(String username, String nume, String prenume, String email, String password, String role) {
        this.username = username;
        this.nume = nume;
        this.prenume = prenume;
        this.email = email;
        this.password = password;
        this.role = role;
    }

    public User(Long id_user, String username, String nume, String prenume, String email, String password, String role) {
        this.id_user = id_user;
        this.username = username;
        this.nume = nume;
        this.prenume = prenume;
        this.email = email;
        this.password = password;
        this.role = role;
    }

    public User(Long id_user, String username, String nume, String prenume, String email, String password, String role, Integer noOfOrders, Integer totalSum) {
        this.id_user = id_user;
        this.username = username;
        this.nume = nume;
        this.prenume = prenume;
        this.email = email;
        this.password = password;
        this.role = role;
        this.noOfOrders = noOfOrders;
        this.totalSum = totalSum;
    }

    public Long getId_user() {
        return id_user;
    }

    public void setId_user(Long id_user) {
        this.id_user = id_user;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getNume() {
        return nume;
    }

    public void setNume(String nume) {
        this.nume = nume;
    }

    public String getPrenume() {
        return prenume;
    }

    public void setPrenume(String prenume) {
        this.prenume = prenume;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public Integer getNoOfOrders() {
        return noOfOrders;
    }

    public void setNoOfOrders(Integer noOfOrders) {
        this.noOfOrders = noOfOrders;
    }

    public Integer getTotalSum() {
        return totalSum;
    }

    public void setTotalSum(Integer totalSum) {
        this.totalSum = totalSum;
    }
}
