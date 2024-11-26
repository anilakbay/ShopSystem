package com.example.shopsystem.model;

import lombok.Data;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.List;

@Entity
@Table(name = "orders")
@Data
public class Order extends BaseEntity {

    private Long customerId; // Müşteri ID'si
    private List<Long> productIds; // Ürün ID'leri

    // İsteğe bağlı olarak burada başka alanlar eklenebilir
}

