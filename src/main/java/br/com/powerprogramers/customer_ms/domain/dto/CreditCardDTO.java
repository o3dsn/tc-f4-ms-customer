package br.com.powerprogramers.customer_ms.domain.dto;

import lombok.Data;

@Data
public class CreditCardDTO {
  private String number;
  private String holderName;
  private String expirationMonth;
  private String expirationYear;
  private String brand;
}
