package com.matriz.lb.products.feign.domain.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class PriceDTO implements Serializable {

    private String id;
    private String description;
    private Double price;
    private Long minQuantity;

}
