package com.matriz.lb.prices.domain.request;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
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
public class CreatePriceRequest implements Serializable {

    @NotEmpty
    private String description;
    @NotNull
    @Min(value = 1)
    private Double price;
    @NotNull
    @Min(value = 1)
    private Long minQuantity;

}
