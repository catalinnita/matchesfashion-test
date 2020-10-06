package com.matchesfashion.papi.controller;

import com.fasterxml.jackson.annotation.JsonView;
import com.matchesfashion.papi.api.jsonview.View;
import com.matchesfashion.papi.api.dto.ProductsDto;
import com.matchesfashion.papi.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/products")
public class ProductController extends BaseController{

    @Autowired
    private ProductService productService;

    @RequestMapping(method = RequestMethod.GET, value = "/all")
    @JsonView(value = View.Product.class)
    public ProductsDto getAllProduct() {
        return productService.findAll();
    }

    @RequestMapping(method = RequestMethod.GET, value = "/price-greater-than/{price}")
    @JsonView(value = View.Product.class)
    public ProductsDto findProductByPriceGreaterThen(@PathVariable(value = "price")Integer price) {
        return productService.findByPriceGreaterThen(price);
    }
}
