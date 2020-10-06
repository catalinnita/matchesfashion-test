package com.matchesfashion.papi.service;

import com.matchesfashion.papi.BaseIntegrationTest;
import com.matchesfashion.papi.api.dto.ProductsDto;
import com.matchesfashion.papi.domain.builder.ProductBuilder;
import com.matchesfashion.papi.repository.ProductRepository;
import org.apache.logging.log4j.util.Strings;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Arrays;

import static junit.framework.TestCase.assertTrue;
import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
public class ProductServiceTest extends BaseIntegrationTest {

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private ProductService productService;

    @Before
    public void prepare(){
        productRepository.save(new ProductBuilder().withTitle("Shirt").withCategory("Menswear").withPrice(150).build());
        productRepository.save(new ProductBuilder().withTitle("T-Shirt").withCategory("Menswear").withPrice(50).build());
        productRepository.save(new ProductBuilder().withTitle("Trousers").withCategory("Menswear").withPrice(80).build());
    }

    @Test
    public void shouldReturAProductsDto() {
        ProductsDto productsDto = productService.findByPriceGreaterThen(50);
        assertEquals(productsDto.getProductList().size(), 2);

        ProductsDto expected = new ProductsDto(Arrays.asList(
                new ProductBuilder().withTitle("Shirt").withCategory("Menswear").withPrice(150).build(),
                new ProductBuilder().withTitle("Trousers").withCategory("Menswear").withPrice(80).build()
                ));
        assertArrayEquals(expected.getProductList().toArray(), productsDto.getProductList().toArray());
        assertTrue(Strings.isEmpty(productsDto.getMessage()));
    }
}
