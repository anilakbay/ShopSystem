package com.example.shopsystem.model;

import lombok.EqualsAndHashCode;
import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "customers")
@Data
@EqualsAndHashCode(callSuper = true)  // Bu satır eklendi
public class Customer extends BaseEntity {

    private String firstName;
    private String lastName;

    @Column(unique = true, nullable = false)
    private String email;

    private String phoneNumber;
    private String address;

    // Müşterinin sepeti, Cart sınıfında customer alanı olması gerekiyor
    @OneToOne(mappedBy = "customer", cascade = CascadeType.ALL)
    private Cart cart;

    // Müşterinin siparişleri, Order sınıfında customer alanı olması gerekiyor
    @OneToMany(mappedBy = "customer", cascade = CascadeType.ALL)
    private List<Order> orders;
}
