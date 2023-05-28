package com.example.finalprojectsd.repository;

import com.example.finalprojectsd.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Long> {
}
