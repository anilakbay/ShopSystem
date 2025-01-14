package com.example.shopsystem.repository;

import com.example.shopsystem.model.Cart;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CartRepository extends JpaRepository<Cart, Long> {
}
