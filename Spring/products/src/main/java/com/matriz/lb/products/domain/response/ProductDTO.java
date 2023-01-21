package com.matriz.lb.products.domain.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class ProductDTO implements Serializable {

    private Long productId;
    private String name;
    private String description;
    private List<ProductPriceDTO> prices;

}
