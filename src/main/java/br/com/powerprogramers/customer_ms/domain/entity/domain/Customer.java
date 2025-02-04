package br.com.powerprogramers.customer_ms.domain.entity.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Customer {
  private String name;
  private String lastName;
  private Address address;
}
