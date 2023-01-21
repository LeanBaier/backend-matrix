package com.matriz.lb.prices.services.impl;

import com.matriz.lb.prices.domain.request.CreatePriceRequest;
import com.matriz.lb.prices.domain.response.GetPricesResponse;
import com.matriz.lb.prices.domain.response.PriceDTO;
import com.matriz.lb.prices.repository.dao.PriceDAO;
import com.matriz.lb.prices.repository.entity.Price;
import com.matriz.lb.prices.services.PricesService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PricesServiceImpl implements PricesService {

    private final PriceDAO priceDAO;

    public PricesServiceImpl(PriceDAO priceDAO) {
        this.priceDAO = priceDAO;
    }

    @Override
    public GetPricesResponse getPricesByProductId(Long productId) {
        List<Price> prices = priceDAO.findAllByProductId(productId);
        return GetPricesResponse.builder()
                .prices(prices.stream().map(p -> PriceDTO.builder()
                        .price(p.getPrice())
                        .description(p.getDescription())
                        .id(p.getId())
                        .minQuantity(p.getMinQuantity())
                        .build()
                ).collect(Collectors.toList()))
                .build();
    }

    @Override
    public void createPrice(Long productId, CreatePriceRequest request) {
        priceDAO.save(Price.builder()
                .description(request.getDescription())
                .price(request.getPrice())
                .minQuantity(request.getMinQuantity())
                .productId(productId)
                .build());
    }
}
