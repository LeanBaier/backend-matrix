package com.matriz.lb.prices.services;

import com.matriz.lb.prices.domain.request.CreatePriceRequest;
import com.matriz.lb.prices.domain.response.GetPricesResponse;

public interface PricesService {

    GetPricesResponse getPricesByProductId(Long productId);

    void createPrice(Long productId, CreatePriceRequest request);

}
