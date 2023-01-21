package com.matriz.lb.prices.repository.dao;

import com.matriz.lb.prices.repository.entity.Price;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface PriceDAO extends MongoRepository<Price, String> {

    List<Price> findAllByProductId(Long productId);

}
