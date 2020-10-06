package com.matchesfashion.papi;

import com.matchesfashion.papi.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

@Transactional //Rollback all transaction after each test
@SpringBootTest(classes = PapiApplication.class)
public class BaseIntegrationTest {

}
