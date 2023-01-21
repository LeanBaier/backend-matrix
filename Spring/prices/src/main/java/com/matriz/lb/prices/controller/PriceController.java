package com.matriz.lb.prices.controller;

import com.matriz.lb.prices.domain.request.CreatePriceRequest;
import com.matriz.lb.prices.domain.response.GetPricesResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.http.ResponseEntity;

public interface PriceController {

    @Operation(description = "Create a new price for a specific product", summary = "Create a price")
    @ApiResponses({
            @ApiResponse(responseCode = "201", description = "Price created!"),
            @ApiResponse(responseCode = "500", description = "Error creating a new price.")
    })
    ResponseEntity<Void> createPrice(@Parameter(name = "productId", description = "Product ID for the new price.") Long productId, CreatePriceRequest request);

    @Operation(description = "Get all the prices for a specific product.", summary = "Get the prices for specific product.")
    @ApiResponses({
            @ApiResponse(responseCode = "200", content = @Content(schema = @Schema(implementation = GetPricesResponse.class))),
            @ApiResponse(responseCode = "500", description = "Error getting all prices.")
    })
    GetPricesResponse getPricesByProductId(Long productId);

}
