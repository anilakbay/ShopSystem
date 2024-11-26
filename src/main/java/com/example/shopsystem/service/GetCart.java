package com.example.shopsystem.service;

import com.example.shopsystem.model.Cart;
import com.example.shopsystem.repository.CartRepository;
import org.springframework.stereotype.Service;

@Service
public class CartService {

    private final CartRepository cartRepository;

    public CartService(CartRepository cartRepository) {
        this.cartRepository = cartRepository;
    }

    // Sepeti getirme
    public Cart getCart(Long customerId) {
        return cartRepository.findByCustomerId(customerId).orElse(null);
    }
}

