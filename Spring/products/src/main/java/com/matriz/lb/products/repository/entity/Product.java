package com.matriz.lb.products.repository.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "PRODUCTS")
public class Product implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_PRODUCT")
    private Long id;
    @Column(name = "NAME", length = 50, nullable = false)
    private String name;
    @Column(name = "DESCRIPTION", length = 200)
    private String description;

}
