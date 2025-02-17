package br.com.powerprogramers.customer_ms.domain.entity.domain;

import lombok.*;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Customer {
  private String name;
  private String lastName;
  private Address address;
  private CreditCard creditCard;
}
