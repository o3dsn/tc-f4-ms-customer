package br.com.powerprogramers.customer_ms.domain.entity.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Address {
  private String street;
  private String number;
  private String neighborhood;
  private String city;
  private String state;
  private String zipCode;
  private String additionalInfo;
}
