package com.matriz.lb.prices.controller;

import com.matriz.lb.prices.domain.request.CreatePriceRequest;
import com.matriz.lb.prices.domain.response.GetPricesResponse;

public interface PriceController {

    void createPrice(Long productId, CreatePriceRequest request);

    GetPricesResponse getPricesByProductId(Long productId);

}
