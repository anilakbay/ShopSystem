package com.example.shopsystem.service;

import com.example.shopsystem.model.Product;
import com.example.shopsystem.repository.ProductRepository;
import org.springframework.stereotype.Service;

@Service
public class ProductService {

    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    // Yeni ürün ekle
    public Product createProduct(Product product) {
        return productRepository.save(product);
    }
}

