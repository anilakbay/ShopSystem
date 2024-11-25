package com.example.shopsystem.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "customers")
@Data  // Lombok sayesinde getter, setter, toString, equals ve hashCode metodları otomatik olarak oluşturulur.
public class Customer extends BaseEntity {

    private String firstName;
    private String lastName;
    private String email;
}
