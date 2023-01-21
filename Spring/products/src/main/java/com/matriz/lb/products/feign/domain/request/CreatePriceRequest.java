package com.matriz.lb.products.feign.domain.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CreatePriceRequest implements Serializable {

    private String description;
    private Double price;
    private Long minQuantity;

}
