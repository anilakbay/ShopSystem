package com.example.shopsystem.service;

import com.example.shopsystem.model.Cart;
import com.example.shopsystem.model.Product;
import com.example.shopsystem.repository.CartRepository;
import com.example.shopsystem.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CartService {

    @Autowired
    private CartRepository cartRepository;

    @Autowired
    private ProductRepository productRepository;

    // Sepete ürün ekleme
    public Cart addProductToCart(Long cartId, Long productId, int quantity) {
        Cart cart = getCartById(cartId);
        Product product = getProductById(productId);

        // Ürün stok kontrolü
        if (product.getStockQuantity() < quantity) {
            throw new RuntimeException("Ürün stokta yeterli miktarda mevcut değil.");
        }

        cart.addProduct(product, quantity);
        cartRepository.save(cart);
        return cart;
    }

    // Sepeti güncelleme (ürün miktarı güncelleme)
    public Cart updateCart(Long cartId, Long productId, int quantity) {
        Cart cart = getCartById(cartId);
        Product product = getProductById(productId);

        cart.updateProductQuantity(product, quantity);
        cartRepository.save(cart);
        return cart;
    }

    // Sepeti temizleme
    public void emptyCart(Long cartId) {
        Cart cart = getCartById(cartId);
        cart.clear();
        cartRepository.save(cart);
    }

    // Sepeti almak
    public Cart getCart(Long cartId) {
        return getCartById(cartId);
    }

    // Yardımcı metodlar
    private Cart getCartById(Long cartId) {
        return cartRepository.findById(cartId)
                .orElseThrow(() -> new RuntimeException("Sepet bulunamadı."));
    }

    private Product getProductById(Long productId) {
        return productRepository.findById(productId)
                .orElseThrow(() -> new RuntimeException("Ürün bulunamadı."));
    }
}

