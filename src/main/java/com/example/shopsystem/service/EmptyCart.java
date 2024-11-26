package com.example.shopsystem.service;

import com.example.shopsystem.repository.CartRepository;
import org.springframework.stereotype.Service;

@Service
public class CartService {

    private final CartRepository cartRepository;

    public CartService(CartRepository cartRepository) {
        this.cartRepository = cartRepository;
    }

    // Sepeti boşaltma
    public void emptyCart(Long cartId) {
        Cart cart = cartRepository.findById(cartId).orElse(null);
        if (cart != null) {
            cart.setTotalPrice(0.0);
            cartRepository.save(cart);
        }
    }
}

