package com.example.shopsystem.repository;

import com.example.shopsystem.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
    // Buraya ürünle ilgili özel sorgular ekleyebilirsiniz.
}

