package com.matriz.lb.products.service.impl;

import com.matriz.lb.products.domain.request.GetProductsParams;
import com.matriz.lb.products.domain.response.GetProductsResponse;
import com.matriz.lb.products.domain.response.ProductDTO;
import com.matriz.lb.products.feign.PricesFeignClient;
import com.matriz.lb.products.repository.dao.ProductDAO;
import com.matriz.lb.products.repository.entity.Product;
import com.matriz.lb.products.service.ProductsService;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductsServiceImpl implements ProductsService {

    private final ProductDAO productDAO;
    private final PricesFeignClient pricesFeignClient;

    public ProductsServiceImpl(ProductDAO productDAO, PricesFeignClient feignClient) {
        this.productDAO = productDAO;
        this.pricesFeignClient = feignClient;
    }

    @Override
    public GetProductsResponse getProducts(GetProductsParams params) {
        var sort = Sort.by("name").ascending();
        var pageable = PageRequest.of(params.getPage(), params.getQuantity(), sort);
        List<Product> products = productDAO.findAll(pageable).stream().toList();
        return GetProductsResponse.builder()
                .products(products
                        .stream()
                        .map(p -> ProductDTO.builder()
                                .id(p.getId())
                                .name(p.getName())
                                .description(p.getDescription())
                                .prices(pricesFeignClient.getPricesByProductId(p.getId()))
                                .build())
                        .collect(Collectors.toList()))
                .page(params.getPage())
                .quantity(products.size())
                .build();
    }
}
