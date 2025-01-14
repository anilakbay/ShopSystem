package com.example.shopsystem.model;

import lombok.Data;
import lombok.EqualsAndHashCode;
import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "products")
@Data
@EqualsAndHashCode(callSuper = true)  // Bu şekilde BaseEntity'deki equals ve hashCode metotları da dikkate alınır.
public class Product extends BaseEntity {

    private String name;
    private BigDecimal price;
    private Integer stockQuantity;
}
