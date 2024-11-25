package com.example.shopsystem.service;

import com.example.shopsystem.model.Cart;
import com.example.shopsystem.model.Product;
import com.example.shopsystem.repository.CartRepository;
import com.example.shopsystem.repository.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CartService {

    private final CartRepository cartRepository;
    private final ProductRepository productRepository;

    public CartService(CartRepository cartRepository, ProductRepository productRepository) {
        this.cartRepository = cartRepository;
        this.productRepository = productRepository;
    }

    // Tüm sepetleri getirme
    public List<Cart> getAllCarts() {
        return cartRepository.findAll();
    }

    // Sepeti ID'ye göre getirme
    public Cart getCartById(Long id) {
        return cartRepository.findById(id).orElse(null);
    }

    // Yeni sepet oluşturma
    public Cart saveCart(Cart cart) {
        return cartRepository.save(cart);
    }

    // Sepeti silme
    public void deleteCart(Long id) {
        cartRepository.deleteById(id);
    }

    // Sepete ürün ekleme
    public Cart addProductToCart(Long cartId, Long productId) {
        Cart cart = cartRepository.findById(cartId).orElse(null);
        if (cart != null) {
            Optional<Product> product = productRepository.findById(productId);
            product.ifPresent(cart::addProduct);  // Sepete ürün ekleme
            cartRepository.save(cart);
        }
        return cart;
    }

    // Sepetten ürün çıkarma
    public Cart removeProductFromCart(Long cartId, Long productId) {
        Cart cart = cartRepository.findById(cartId).orElse(null);
        if (cart != null) {
            Optional<Product> product = productRepository.findById(productId);
            product.ifPresent(cart::removeProduct);  // Sepetten ürün çıkarma
            cartRepository.save(cart);
        }
        return cart;
    }

    // Sepetteki tüm ürünleri getirme
    public List<Product> getProductsInCart(Long cartId) {
        Cart cart = cartRepository.findById(cartId).orElse(null);
        return cart != null ? cart.getProducts() : null;
    }
}
