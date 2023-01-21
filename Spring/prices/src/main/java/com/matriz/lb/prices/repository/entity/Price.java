package com.matriz.lb.prices.repository.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Document("prices")
public class Price {

    @Id
    private String id;
    private String description;
    private Double price;
    private Long minQuantity;
    private Long productId;
}
