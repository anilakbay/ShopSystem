package com.example.shopsystem.controller;

import com.example.shopsystem.model.Cart;
import com.example.shopsystem.model.Product;
import com.example.shopsystem.service.CartService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/carts")
public class CartController {

    private final CartService cartService;

    public CartController(CartService cartService) {
        this.cartService = cartService;
    }

    @GetMapping
    public ResponseEntity<List<Cart>> getAllCarts() {
        List<Cart> carts = cartService.getAllCarts();
        return carts.isEmpty() ? ResponseEntity.noContent().build() : ResponseEntity.ok(carts);
    }

    @GetMapping("/{cartId}")
    public ResponseEntity<Cart> getCartById(@PathVariable Long cartId) {
        try {
            Cart cart = cartService.getCartById(cartId);
            return ResponseEntity.ok(cart);
        } catch (RuntimeException e) {
            return ResponseEntity.status(404).build();  // Cart not found
        }
    }

    @PostMapping
    public ResponseEntity<Cart> createCart(@Valid @RequestBody Cart cart) {
        Cart createdCart;
        createdCart = cartService.saveCart(cart);
        return ResponseEntity.status(201).body(createdCart);
    }

    @DeleteMapping("/{cartId}")
    public ResponseEntity<Void> deleteCart(@PathVariable Long cartId) {
        boolean isDeleted = cartService.deleteCart(cartId);
        return isDeleted ? ResponseEntity.noContent().build() : ResponseEntity.status(404).build();
    }

    @PostMapping("/{cartId}/products/{productId}")
    public ResponseEntity<Cart> addProductToCart(@PathVariable Long cartId, @PathVariable Long productId) {
        try {
            Cart updatedCart = cartService.addProductToCart(cartId, productId);
            return ResponseEntity.ok(updatedCart);
        } catch (RuntimeException e) {
            return ResponseEntity.status(404).build();  // Product or Cart not found
        }
    }

    @DeleteMapping("/{cartId}/products/{productId}")
    public ResponseEntity<Cart> removeProductFromCart(@PathVariable Long cartId, @PathVariable Long productId) {
        try {
            Cart updatedCart = cartService.removeProductFromCart(cartId, productId);
            return ResponseEntity.ok(updatedCart);
        } catch (RuntimeException e) {
            return ResponseEntity.status(404).build();  // Product or Cart not found
        }
    }

    @GetMapping("/{cartId}/products")
    public ResponseEntity<List<Product>> getProductsInCart(@PathVariable Long cartId) {
        try {
            List<Product> products = cartService.getProductsInCart(cartId);
            return products.isEmpty() ? ResponseEntity.noContent().build() : ResponseEntity.ok(products);
        } catch (RuntimeException e) {
            return ResponseEntity.status(404).build();  // Cart not found
        }
    }
}
