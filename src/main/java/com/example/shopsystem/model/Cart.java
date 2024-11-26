package com.example.shopsystem.model;

import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "carts")
@Data
public class Cart extends BaseEntity {

    @ManyToOne
    @JoinColumn(name = "customer_id", nullable = false)  // Sepet, bir müşteri ile ilişkilidir ve bu ilişki zorunludur
    private Customer customer;

    private Double totalPrice;  // Sepetin toplam fiyatı

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)  // Sepetteki ürünler bir liste olarak tutuluyor
    @JoinColumn(name = "cart_id")  // Bu, Cart ve Product arasındaki ilişkiyi belirtir
    private List<Product> products = new ArrayList<>();  // Sepetteki ürünler

    // Sepete ürün eklemek için yardımcı metod
    public void addProduct(Product product) {
        this.products.add(product);
        this.totalPrice += product.getPrice();  // Ürünün fiyatını toplam fiyata ekle
    }
}
