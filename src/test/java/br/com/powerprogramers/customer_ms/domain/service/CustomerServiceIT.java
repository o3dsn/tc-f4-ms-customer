package br.com.powerprogramers.customer_ms.domain.service;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import br.com.powerprogramers.customer_ms.domain.dto.AddressDTO;
import br.com.powerprogramers.customer_ms.domain.dto.CreditCardDTO;
import br.com.powerprogramers.customer_ms.domain.dto.CustomerDTO;
import br.com.powerprogramers.customer_ms.domain.repository.CustomerRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

@SpringBootTest
@AutoConfigureMockMvc
public class CustomerServiceIT {

  @Autowired private MockMvc mockMvc;

  @Autowired private ObjectMapper objectMapper;

  @Autowired private CustomerRepository customerRepository;

  private CustomerDTO customerDTO;

  @BeforeEach
  void setUp() {
    customerRepository.deleteAll();

    AddressDTO addressDTO = new AddressDTO();
    addressDTO.setStreet("Rua Principal");
    addressDTO.setNumber("123");
    addressDTO.setCity("São Paulo");
    addressDTO.setState("SP");
    addressDTO.setZipCode("01000-000");

    CreditCardDTO creditCardDTO = new CreditCardDTO();
    creditCardDTO.setNumber("4111111111111111");
    creditCardDTO.setExpirationMonth("12");
    creditCardDTO.setExpirationMonth("26");
    creditCardDTO.setBrand("VISA");

    customerDTO = new CustomerDTO();
    customerDTO.setName("Joao");
    customerDTO.setLastName("Silva");
    customerDTO.setAddress(addressDTO);
    customerDTO.setCreditCard(creditCardDTO);
  }

  @Test
  void shouldCreateCustomer() throws Exception {
    String customerJson = objectMapper.writeValueAsString(customerDTO);

    mockMvc
        .perform(post("/customers").contentType(MediaType.APPLICATION_JSON).content(customerJson))
        .andExpect(status().isOk());
  }

  @Test
  void shouldFindAllCustomers() throws Exception {
    String customerJson = objectMapper.writeValueAsString(customerDTO);

    mockMvc
        .perform(post("/customers").contentType(MediaType.APPLICATION_JSON).content(customerJson))
        .andExpect(status().isOk());

    mockMvc
        .perform(get("/customers"))
        .andExpect(status().isOk())
        .andExpect(jsonPath("$.length()").value(1));
  }

  @Test
  void shouldReturnNotFoundWhenCustomerDoesNotExist() throws Exception {
    mockMvc.perform(get("/customers/999")).andExpect(status().isNotFound());
  }
}
