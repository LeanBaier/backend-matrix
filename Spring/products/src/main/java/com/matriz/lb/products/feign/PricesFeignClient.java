package com.matriz.lb.products.feign;


import com.matriz.lb.products.domain.response.PriceDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(value = "pricesclient", url="http://localhost:9002")
public interface PricesFeignClient {

    @GetMapping(path = "/products/{idProduct}/prices")
    List<PriceDTO> getPricesByProductId(@PathVariable("idProduct") Long idProduct);

}
