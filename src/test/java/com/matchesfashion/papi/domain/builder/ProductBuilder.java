package com.matchesfashion.papi.domain.builder;

import com.matchesfashion.papi.domain.Product;

/**
 * Utility class to quickly create a Product instance
 */
public class ProductBuilder {

    private Product product;

    public ProductBuilder() {
        this.product = new Product();
    }

    public Product build() {
        return this.product;
    }

    public ProductBuilder withId(Integer id) {
        this.product.setId(id);
        return this;
    }

    public ProductBuilder withTitle(String title) {
        this.product.setTitle(title);
        return this;
    }

    public ProductBuilder withCategory(String category) {
        this.product.setCategory(category);
        return this;
    }

    public ProductBuilder withPrice(Integer price) {
        this.product.setPrice(price);
        return this;
    }
}
