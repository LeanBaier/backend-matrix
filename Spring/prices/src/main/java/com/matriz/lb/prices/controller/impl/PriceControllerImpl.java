package com.matriz.lb.prices.controller.impl;

import com.matriz.lb.prices.controller.PriceController;
import com.matriz.lb.prices.domain.request.CreatePriceRequest;
import com.matriz.lb.prices.domain.response.GetPricesResponse;
import com.matriz.lb.prices.services.PricesService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1/api")
public class PriceControllerImpl implements PriceController {

    private final PricesService pricesService;

    public PriceControllerImpl(PricesService pricesService) {
        this.pricesService = pricesService;
    }

    @PostMapping("/products/{productId}/prices")
    @Override
    public void createPrice(@PathVariable(name = "productId") Long productId,
                            @Valid @RequestBody CreatePriceRequest request) {
        pricesService.createPrice(productId, request);
    }

    @GetMapping("/products/{productId}/prices")
    @Override
    public GetPricesResponse getPricesByProductId(Long productId) {
        return pricesService.getPricesByProductId(productId);
    }
}
