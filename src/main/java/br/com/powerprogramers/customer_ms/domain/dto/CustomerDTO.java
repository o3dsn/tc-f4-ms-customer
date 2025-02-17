package br.com.powerprogramers.customer_ms.domain.dto;

import lombok.Data;

@Data
public class CustomerDTO {
  private Long id;
  private String name;
  private String lastName;
  private AddressDTO address;
  private CreditCardDTO creditCard;
}
