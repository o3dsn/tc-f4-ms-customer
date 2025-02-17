package br.com.powerprogramers.customer_ms.bdd.steps;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

@SpringBootTest
@AutoConfigureMockMvc
public class CustomerSteps {

  @Autowired private MockMvc mockMvc;
  private MvcResult result;

  @When("eu faço uma requisição GET para customers {string}")
  public void eu_faco_uma_requisicao_get_para_customers(String endpoint) throws Exception {
    result = mockMvc.perform(get(endpoint).contentType(MediaType.APPLICATION_JSON)).andReturn();
  }

  @Then("o status da resposta deve ser {int} para customers")
  public void o_status_da_resposta_deve_ser(Integer statusCode) throws Exception {
    result.getResponse().getStatus();
  }
}
