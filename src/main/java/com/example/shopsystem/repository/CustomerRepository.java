package com.example.shopsystem.repository;

import com.example.shopsystem.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface CustomerRepository extends JpaRepository<Customer, Long> {

    Optional<Customer> findByEmail(String email); // Customer'ı e-posta ile bulmak için

}


