package com.example.shopsystem.model;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "carts")
@Data
@EqualsAndHashCode(callSuper = true)
public class Cart extends BaseEntity {

    @ManyToOne
    @JoinColumn(name = "customer_id", nullable = false)
    private Customer customer;

    private BigDecimal totalPrice = BigDecimal.ZERO;

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "cart_id")
    private List<Product> products = new ArrayList<>();

    public void addProduct(Product product) {
        if (product != null) {
            products.add(product);
            recalculateTotalPrice();
        }
    }

    public void removeProduct(Product product) {
        if (products.remove(product)) {
            recalculateTotalPrice();
        }
    }

    // Daha sade ve doğru bir toplam fiyat hesaplama
    private void recalculateTotalPrice() {
        totalPrice = products.stream()
                .map(Product::getPrice)  // BigDecimal fiyatları alıyoruz
                .reduce(BigDecimal.ZERO, BigDecimal::add);  // Toplam fiyatı hesaplıyoruz
    }
}
