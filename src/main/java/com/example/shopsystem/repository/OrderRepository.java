package com.example.shopsystem.repository;

import com.example.shopsystem.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface OrderRepository extends JpaRepository<Order, Long> {
    // Müşteriye ait siparişleri getiren özel sorgu
    List<Order> findByCustomerId(Long customerId);
}

