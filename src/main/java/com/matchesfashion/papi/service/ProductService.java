package com.matchesfashion.papi.service;

import com.matchesfashion.papi.api.dto.ProductsDto;
import com.matchesfashion.papi.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    public ProductsDto findAll() {
        return new ProductsDto(productRepository.findAll());
    }

    public ProductsDto findByPriceGreaterThen(Integer price) {
        return new ProductsDto(productRepository.findByPriceGreaterThan(price));
    }
}
