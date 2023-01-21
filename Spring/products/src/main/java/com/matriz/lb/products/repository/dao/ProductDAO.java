package com.matriz.lb.products.repository.dao;

import com.matriz.lb.products.repository.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductDAO extends JpaRepository<Product, Long> {

}
