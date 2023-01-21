package com.matriz.lb.products.controller.impl;

import com.matriz.lb.products.controller.ProductsController;
import com.matriz.lb.products.domain.response.GetProductsResponse;
import com.matriz.lb.products.service.ProductsService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1/api")
public class ProductsControllerImpl implements ProductsController {

    private final ProductsService productsService;

    public ProductsControllerImpl(ProductsService productsService) {
        this.productsService = productsService;
    }

    @GetMapping("/products")
    @Override
    public GetProductsResponse getProducts(@RequestParam @Min(value = 1) Integer page,
                                           @RequestParam @Min(value = 1) @Max(value = 20) Integer quantity) {
        return productsService.getProducts(page, quantity);
    }

    @PostMapping("/products")
    @Override
    public ResponseEntity<Void> generateProducts() {
        productsService.generateProducts();
        return ResponseEntity.status(201).build();
    }
}
