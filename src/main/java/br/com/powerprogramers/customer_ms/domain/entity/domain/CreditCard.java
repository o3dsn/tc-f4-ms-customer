package br.com.powerprogramers.customer_ms.domain.entity.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CreditCard {
  private String number;
  private String holderName;
  private String expirationMonth;
  private String expirationYear;
  private String brand;
}
