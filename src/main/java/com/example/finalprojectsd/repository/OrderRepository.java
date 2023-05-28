package com.example.finalprojectsd.repository;

import com.example.finalprojectsd.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order,Long> {
}
