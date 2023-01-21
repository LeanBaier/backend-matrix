package com.matriz.lb.products.domain.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class ProductPriceDTO implements Serializable {

    private String id;
    private String description;
    private Double price;
    private Long minQuantity;

}
