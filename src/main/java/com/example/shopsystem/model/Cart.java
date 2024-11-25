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
    @JoinColumn(name = "customer_id")  // Sepet, bir müşteri ile ilişkilidir
    private Customer customer;

    private Double totalPrice;  // Sepetin toplam fiyatı
}

