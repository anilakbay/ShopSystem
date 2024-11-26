package com.example.shopsystem.service;

import com.example.shopsystem.model.Cart;
import com.example.shopsystem.model.Product;
import com.example.shopsystem.repository.CartRepository;
import org.springframework.stereotype.Service;

@Service
public class CartService {

    private final CartRepository cartRepository;

    public CartService(CartRepository cartRepository) {
        this.cartRepository = cartRepository;
    }

    // Sepetten ürün çıkarma
    public Cart removeProductFromCart(Long cartId, Product product) {
        Cart cart = cartRepository.findById(cartId).orElse(null);
        if (cart != null) {
            cart.getProducts().remove(product);
            cart.setTotalPrice(cart.getTotalPrice() - product.getPrice());
            return cartRepository.save(cart);
        }
        return null;
    }
}

