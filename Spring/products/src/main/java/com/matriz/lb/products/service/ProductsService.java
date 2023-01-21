package com.matriz.lb.products.service;

import com.matriz.lb.products.domain.response.GetProductsResponse;

public interface ProductsService {

    GetProductsResponse getProducts(Integer page, Integer quantity);
    void generateProducts();

}
