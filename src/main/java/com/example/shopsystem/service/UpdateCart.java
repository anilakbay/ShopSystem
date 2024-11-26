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

    // Sepeti güncelleme
    public Cart updateCart(Long cartId, Cart cartDetails) {
        Cart cart = cartRepository.findById(cartId).orElse(null);
        if (cart != null) {
            cart.setTotalPrice(cartDetails.getTotalPrice());
            return cartRepository.save(cart);
        }
        return null;
    }
}
