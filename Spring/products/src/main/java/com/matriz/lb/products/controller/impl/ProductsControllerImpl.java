package com.matriz.lb.products.controller.impl;

import com.matriz.lb.products.controller.ProductsController;
import com.matriz.lb.products.domain.request.GetProductsParams;
import com.matriz.lb.products.domain.response.GetProductsResponse;
import com.matriz.lb.products.service.ProductsService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/api")
public class ProductsControllerImpl implements ProductsController {

    private final ProductsService productsService;

    public ProductsControllerImpl(ProductsService productsService) {
        this.productsService = productsService;
    }

    @GetMapping("/products")
    @Override
    public GetProductsResponse getProducts(@Valid GetProductsParams params) {
        return productsService.getProducts(params);
    }

    @PostMapping("/products")
    @Override
    public ResponseEntity<Void> generateProducts() {
        productsService.generateProducts();
        return ResponseEntity.status(201).build();
    }
}
