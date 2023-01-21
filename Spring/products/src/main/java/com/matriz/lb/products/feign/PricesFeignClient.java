package com.matriz.lb.products.feign;


import com.matriz.lb.products.feign.domain.request.CreatePriceRequest;
import com.matriz.lb.products.feign.domain.response.GetPricesResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(value = "pricesclient", url="http://localhost:9002/v1/api")
public interface PricesFeignClient {

    @PostMapping("/products/{productId}/prices")
    public void createPrice(@PathVariable(name = "productId") Long productId,
                            @RequestBody CreatePriceRequest request);
    @GetMapping(path = "/products/{productId}/prices")
    GetPricesResponse getPricesByProductId(@PathVariable("productId") Long idProduct);

}
