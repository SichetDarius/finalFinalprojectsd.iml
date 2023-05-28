package com.example.finalprojectsd.repository;

import com.example.finalprojectsd.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product,Long> {
}
