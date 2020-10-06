package com.matchesfashion.papi.controller;

import com.matchesfashion.papi.BaseControllerTest;
import com.matchesfashion.papi.api.ValidationCode;
import com.matchesfashion.papi.domain.builder.ProductBuilder;
import com.matchesfashion.papi.repository.ProductRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import static net.bytebuddy.matcher.ElementMatchers.is;
import static org.hamcrest.collection.IsCollectionWithSize.hasSize;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@Transactional
@RunWith(SpringRunner.class)
public class ProductControllerTest extends BaseControllerTest {

    private static final String find_Product_By_Price_Greater_Then_url = "/products/price-greater-than/%s";

    @Autowired
    private ProductRepository productRepository;

    @Before
    public void prepare(){
        productRepository.save(new ProductBuilder().withTitle("Shirt").withCategory("Menswear").withPrice(150).build());
        productRepository.save(new ProductBuilder().withTitle("T-Shirt").withCategory("Menswear").withPrice(50).build());
        productRepository.save(new ProductBuilder().withTitle("Trousers").withCategory("Menswear").withPrice(80).build());
    }

    @Test
    public void shouldFindProductByPriceGreaterThenReturnOkHttpCode() throws Exception {
        this.mockMvc
                .perform(
                        get(String.format(find_Product_By_Price_Greater_Then_url,50))
                )
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.productList", hasSize(2)))
                .andExpect(jsonPath("$.message").doesNotExist());
    }

    @Test
    public void shouldFindProductByPriceGreaterThenReturnBadRequestCode() throws Exception {
        this.mockMvc
                .perform(
                        get(String.format(find_Product_By_Price_Greater_Then_url,"xxx"))
                )
                .andDo(print())
                .andExpect(status().isBadRequest())
                .andExpect(jsonPath("$.message").value(ValidationCode.NFE_MESSAGE));
    }
}
