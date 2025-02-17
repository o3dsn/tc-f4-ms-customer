package br.com.powerprogramers.customer_ms.bdd;

import br.com.powerprogramers.customer_ms.CustomerMsApplication;
import io.cucumber.spring.CucumberContextConfiguration;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;

@CucumberContextConfiguration
@SpringBootTest(
    webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT,
    classes = CustomerMsApplication.class)
@AutoConfigureMockMvc
public class CucumberSpringConfiguration {}
