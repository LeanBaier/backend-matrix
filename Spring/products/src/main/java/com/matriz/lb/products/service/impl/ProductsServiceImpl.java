package com.matriz.lb.products.service.impl;

import com.matriz.lb.products.domain.response.GetProductsResponse;
import com.matriz.lb.products.domain.response.ProductDTO;
import com.matriz.lb.products.domain.response.ProductPriceDTO;
import com.matriz.lb.products.feign.PricesFeignClient;
import com.matriz.lb.products.feign.domain.request.CreatePriceRequest;
import com.matriz.lb.products.repository.dao.ProductDAO;
import com.matriz.lb.products.repository.entity.Product;
import com.matriz.lb.products.service.ProductsService;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;
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
    public GetProductsResponse getProducts(Integer page, Integer quantity) {
        var sort = Sort.by("id").ascending();
        var pageable = PageRequest.of(page - 1, quantity, sort);
        List<Product> products = productDAO.findAll(pageable).stream().toList();
        return GetProductsResponse.builder()
                .products(products
                        .stream()
                        .map(p -> ProductDTO.builder()
                                .productId(p.getId())
                                .name(p.getName())
                                .description(p.getDescription())
                                .prices(Optional.ofNullable(pricesFeignClient.getPricesByProductId(p.getId()).getPrices())
                                        .map(l -> l.stream().map(pr -> ProductPriceDTO.builder()
                                                        .price(pr.getPrice())
                                                        .priceId(pr.getId())
                                                        .minQuantity(pr.getMinQuantity())
                                                        .description(pr.getDescription()).
                                                        build())
                                                .sorted(Comparator.comparing(ProductPriceDTO::getPrice))
                                                .collect(Collectors.toList()))
                                        .orElse(null))
                                .build())
                        .collect(Collectors.toList()))
                .page(page)
                .quantity(products.size())
                .build();
    }

    @Override
    public void generateProducts() {
        for (int i = 1; i <= 20; i++) {
            var product = productDAO.save(Product.builder()
                    .description("Description Product: " + i)
                    .name("Product: " + i)
                    .build()
            );
            for (int j = 20; j >= i; j--) {
                pricesFeignClient.createPrice(product.getId(), CreatePriceRequest.builder()
                        .price(Double.valueOf(j))
                        .description("Product: " + i + " Price: " + j)
                        .minQuantity(Long.valueOf(j))
                        .build()
                );
            }
        }
    }
}
