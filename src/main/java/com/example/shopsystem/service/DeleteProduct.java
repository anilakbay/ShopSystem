package com.example.shopsystem.service;

import com.example.shopsystem.repository.ProductRepository;
import org.springframework.stereotype.Service;

@Service
public class ProductService {

    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    // Ürün silme
    public void deleteProduct(Long id) {
        productRepository.deleteById(id);
    }
}

