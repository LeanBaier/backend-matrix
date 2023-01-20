package com.matriz.lb.products.domain.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class GetProductsResponse implements Serializable {

    private List<ProductDTO> products;
    private Integer page;
    private Integer quantity;

}
