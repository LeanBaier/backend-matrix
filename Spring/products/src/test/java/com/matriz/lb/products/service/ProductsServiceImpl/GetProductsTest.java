package com.matriz.lb.products.service.ProductsServiceImpl;

import com.matriz.lb.products.domain.response.GetProductsResponse;
import com.matriz.lb.products.repository.dao.ProductDAO;
import com.matriz.lb.products.repository.entity.Product;
import com.matriz.lb.products.service.impl.ProductsServiceImpl;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class GetProductsTest {

    @Autowired
    private ProductsServiceImpl service;

    @MockBean
    private ProductDAO dao;

    @Test
    void getProducts_when_DataFound() {
        Page<Product> products = new PageImpl<>(List.of(Product.builder().name("Product 1").description("Desc 1").id(1L).build(),
                Product.builder().name("Product 2").description("Desc 2").id(2L).build()));
        Mockito.when(dao.findAll((Pageable) Mockito.any())).thenReturn(products);
        GetProductsResponse result = service.getProducts(1, 2);
        assertNotNull(result);
        assertFalse(result.getProducts().isEmpty());
        assertEquals(1, result.getPage());
        assertEquals(2, result.getQuantity());
        assertEquals(1L, result.getProducts().get(0).getProductId());

    }

    @Test
    void getProducts_when_NoDataFound() {
        Page<Product> products = Page.empty();
        Mockito.when(dao.findAll((Pageable) Mockito.any())).thenReturn(products);
        GetProductsResponse result = service.getProducts(1, 1);
        assertNotNull(result);
        assertTrue(result.getProducts().isEmpty());
        assertEquals(1, result.getPage());
        assertEquals(0, result.getQuantity());
    }

    @Test
    void getProducts_when_DaoRuntimeException() {
        Mockito.doThrow(new RuntimeException()).when(dao).findAll((Pageable) Mockito.any());
        assertThrows(RuntimeException.class,() -> service.getProducts(1, 1));
    }

}
