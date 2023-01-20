package com.matriz.lb.products.domain.request;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class GetProductsParams implements Serializable {

    @NotNull
    @Min(value = 1)
    private Integer page;
    @Min(value = 10)
    @Max(value = 100)
    private Integer  quantity;

}
