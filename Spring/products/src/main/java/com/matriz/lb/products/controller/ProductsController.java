package com.matriz.lb.products.controller;

import com.matriz.lb.products.domain.request.GetProductsParams;
import com.matriz.lb.products.domain.response.GetProductsResponse;
import org.springframework.http.ResponseEntity;

public interface ProductsController {

    GetProductsResponse getProducts(GetProductsParams params);

    ResponseEntity<Void> generateProducts();

}
