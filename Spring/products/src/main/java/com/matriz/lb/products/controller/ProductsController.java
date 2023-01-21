package com.matriz.lb.products.controller;

import com.matriz.lb.products.domain.response.GetProductsResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.http.ResponseEntity;

public interface ProductsController {

    @Operation(description = "Get product with prices.", summary = "Get products.")
    @ApiResponses({
            @ApiResponse(responseCode = "200", content = @Content(schema = @Schema(implementation = GetProductsResponse.class))),
            @ApiResponse(responseCode = "500", description = "Error getting the products.")
    })
    GetProductsResponse getProducts(@Parameter(description = "Page number.") Integer page, @Parameter(description = "Number of records per page.") Integer quantity);

    @Operation(description = "Create 20 products for test.", summary = "Create products for test.")
    @ApiResponses({
            @ApiResponse(responseCode = "201", description = "Products created."),
            @ApiResponse(responseCode = "500", description = "Error creating the products.")
    })
    ResponseEntity<Void> generateProducts();

}
