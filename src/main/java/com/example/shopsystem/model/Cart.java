package com.example.shopsystem.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "carts")
@Data
public class Cart extends BaseEntity {

    @ManyToOne
    @JoinColumn(name = "customer_id", nullable = false)  // Sepet, bir müşteri ile ilişkilidir ve bu ilişki zorunludur
    private Customer customer;

    private Double totalPrice;  // Sepetin toplam fiyatı

    // Sepete ürün eklemek ve toplam fiyatı hesaplamak gibi işlemler için metodlar eklenebilir.
}
