package com.example.shopsystem.service;

import com.example.shopsystem.model.Product;
import com.example.shopsystem.repository.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ProductService {

    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    // Ürün bilgilerini getirme
    public Product getProduct(Long id) {
        return productRepository.findById(id).orElse(null);
    }
}

