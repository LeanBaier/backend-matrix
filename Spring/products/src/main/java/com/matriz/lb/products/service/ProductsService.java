package com.matriz.lb.products.service;

import com.matriz.lb.products.domain.request.GetProductsParams;
import com.matriz.lb.products.domain.response.GetProductsResponse;

public interface ProductsService {

    GetProductsResponse getProducts(GetProductsParams params);

}
