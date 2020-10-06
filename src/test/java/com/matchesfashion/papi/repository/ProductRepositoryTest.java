package com.matchesfashion.papi.repository;

import com.matchesfashion.papi.BaseIntegrationTest;
import com.matchesfashion.papi.domain.builder.ProductBuilder;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
public class ProductRepositoryTest extends BaseIntegrationTest {

    @Autowired
    private ProductRepository productRepository;

    @Before
    public void prepare(){
        productRepository.save(new ProductBuilder().withTitle("Shirt").withCategory("Menswear").withPrice(150).build());
        productRepository.save(new ProductBuilder().withTitle("T-Shirt").withCategory("Menswear").withPrice(50).build());
        productRepository.save(new ProductBuilder().withTitle("Trousers").withCategory("Menswear").withPrice(80).build());
    }

    @Test
    public void shouldFindProductByPriceGraterThanAValue() {
        assertEquals(productRepository.count(),3);
        assertEquals(productRepository.findByPriceGreaterThan(100).size(),1);
    }

    @Test
    public void shouldFindNoProduct() {
        assertEquals(productRepository.count(),3);
        assertEquals(productRepository.findByPriceGreaterThan(500).size(),0);
    }

}
