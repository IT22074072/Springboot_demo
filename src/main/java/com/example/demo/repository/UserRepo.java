package com.example.demo.repository;


import com.example.demo.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

// The JpaRepository interface is parameterized with User (entity type) and Integer (type of the entity's primary key)
public interface UserRepo extends JpaRepository<User, Integer> {
}
