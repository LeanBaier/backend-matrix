package com.matriz.lb.prices.controller;

import com.matriz.lb.prices.domain.request.CreatePriceRequest;
import com.matriz.lb.prices.domain.response.GetPricesResponse;
import org.springframework.http.ResponseEntity;

public interface PriceController {

    ResponseEntity<Void> createPrice(Long productId, CreatePriceRequest request);

    GetPricesResponse getPricesByProductId(Long productId);

}
