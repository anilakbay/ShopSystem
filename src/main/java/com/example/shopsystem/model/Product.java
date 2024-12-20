package com.example.shopsystem.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "products")
@Data  // Lombok sayesinde getter, setter, toString, equals ve hashCode metodları otomatik olarak oluşturulur.
public class Product extends BaseEntity {

    private String name;
    private Double price;
    private Integer stockQuantity;
}
