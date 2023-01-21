package com.matriz.lb.products.controller.ProductsControllerImpl;

import com.matriz.lb.products.domain.response.GetProductsResponse;
import com.matriz.lb.products.domain.response.ProductDTO;
import com.matriz.lb.products.domain.response.ProductPriceDTO;
import com.matriz.lb.products.service.ProductsService;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.List;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;

@WebMvcTest
public class GetProductsTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private ProductsService service;

    @Test
    void getProducts_when_DataFound() throws Exception {
        Mockito.when(service.getProducts(Mockito.any(), Mockito.any())).thenReturn(GetProductsResponse.builder()
                .quantity(1)
                .page(1)
                .products(List.of(ProductDTO.builder()
                        .productId(1L)
                        .name("Prod 1")
                        .description("Desc 1")
                        .prices(List.of(ProductPriceDTO.builder()
                                .price(1D)
                                .priceId("1")
                                .minQuantity(1L)
                                .description("Price 1").build())).build()))
                .page(1)
                .quantity(1)
                .build());

        mockMvc.perform(MockMvcRequestBuilders
                        .get("/v1/api/products")
                        .param("page", "1")
                        .param("quantity", "1"))
                .andDo(print())
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.products").exists())
                .andExpect(MockMvcResultMatchers.jsonPath("$.products[*]").isNotEmpty())
                .andExpect(MockMvcResultMatchers.jsonPath("$.page").value("1"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.quantity").value("1"));
    }

    @Test
    void getProducts_when_NoDataFound() throws Exception {
        Mockito.when(service.getProducts(Mockito.any(), Mockito.any())).thenReturn(GetProductsResponse.builder().page(1).quantity(0).build());

        mockMvc.perform(MockMvcRequestBuilders
                        .get("/v1/api/products")
                        .param("page", "1")
                        .param("quantity", "1"))
                .andDo(print())
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.products").doesNotExist())
                .andExpect(MockMvcResultMatchers.jsonPath("$.page").value("1"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.quantity").value("0"));
    }

    @Test
    void getProducts_when_ServiceRuntimeException() throws Exception {
        Mockito.doThrow(new RuntimeException()).when(service).getProducts(Mockito.any(), Mockito.any());

        mockMvc.perform(MockMvcRequestBuilders
                        .get("/v1/api/products")
                        .param("page", "1")
                        .param("quantity", "1"))
                .andDo(print())
                .andExpect(MockMvcResultMatchers.status().isInternalServerError())
                .andExpect(MockMvcResultMatchers.content().string("Service Error!"));
    }

}
