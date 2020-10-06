package com.matchesfashion.papi.api.dto;

import com.fasterxml.jackson.annotation.JsonView;
import com.matchesfashion.papi.api.jsonview.View;
import com.matchesfashion.papi.domain.Product;

import java.util.List;

public class ProductsDto extends AbstractDto{

    @JsonView(value = View.Product.class)
    private List<Product> productList;

    public ProductsDto(String message, String error){
        super(message, error);
    }

    public ProductsDto(List<Product> productList) {
        this.productList = productList;
    }

    public String getMessage() {
        return message;
    }

    public List<Product> getProductList() {
        return productList;
    }

}
