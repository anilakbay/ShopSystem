package com.example.shopsystem.controller;

import com.example.shopsystem.model.Cart;
import com.example.shopsystem.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/carts")
public class CartController {

    @Autowired
    private CartService cartService;

    // Sepete ürün ekleme
    @PostMapping("/{cartId}/products/{productId}")
    public ResponseEntity<Cart> addProductToCart(@PathVariable Long cartId, @PathVariable Long productId, @RequestParam int quantity) {
        Cart updatedCart = cartService.addProductToCart(cartId, productId, quantity);
        return ResponseEntity.ok(updatedCart);
    }

    // Sepeti güncelleme
    @PutMapping("/{cartId}/products/{productId}")
    public ResponseEntity<Cart> updateCart(@PathVariable Long cartId, @PathVariable Long productId, @RequestParam int quantity) {
        Cart updatedCart = cartService.updateCart(cartId, productId, quantity);
        return ResponseEntity.ok(updatedCart);
    }

    // Sepeti temizleme
    @DeleteMapping("/{cartId}")
    public ResponseEntity<Void> emptyCart(@PathVariable Long cartId) {
        cartService.emptyCart(cartId);
        return ResponseEntity.noContent().build();
    }

    // Sepeti getirme
    @GetMapping("/{cartId}")
    public ResponseEntity<Cart> getCart(@PathVariable Long cartId) {
        Cart cart = cartService.getCart(cartId);
        return ResponseEntity.ok(cart);
    }
}
