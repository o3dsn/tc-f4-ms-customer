package br.com.powerprogramers.customer_ms.bdd.steps;

import static org.hamcrest.Matchers.equalTo;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

import br.com.powerprogramers.customer_ms.bdd.CucumberSpringConfiguration;
import br.com.powerprogramers.customer_ms.domain.entity.persistence.AddressEntity;
import br.com.powerprogramers.customer_ms.domain.service.AddressService;
import io.cucumber.java.en.Given;
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
public class AddressSteps extends CucumberSpringConfiguration {

  @Autowired private MockMvc mockMvc;
  @Autowired private AddressService addressService;

  private MvcResult result;

  @Given("que o CEP {string} existe")
  public void que_o_cep_existe(String cep) {
    AddressEntity address =
        AddressEntity.builder()
            .street("Avenida Nossa Senhora de Copacabana")
            .city("Rio de Janeiro")
            .state("Rio de Janeiro")
            .zipCode(cep)
            .build();
  }

  @When("eu faço uma requisição GET para addresses {string}")
  public void eu_faco_uma_requisicao_get_para(String endpoint) throws Exception {
    result = mockMvc.perform(get(endpoint).contentType(MediaType.APPLICATION_JSON)).andReturn();
  }

  @Then("o status da resposta deve ser {int}")
  public void o_status_da_resposta_deve_ser(Integer statusCode) throws Exception {
    result.getResponse().getStatus();
  }

  @Then("o JSON da resposta deve conter {string} igual a {string} para addresses")
  public void o_json_da_resposta_deve_conter(String chave, String valor) throws Exception {
    mockMvc
        .perform(get("/cep/22070012"))
        .andExpect(jsonPath("$.street", equalTo("Avenida Nossa Senhora de Copacabana")));
  }
}
