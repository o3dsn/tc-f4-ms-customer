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

// public record CustomerDTO(
//    @NotBlank(message = "O nome não pode estar em branco")
//        @Size(min = 3, message = "O nome deve ter no mínimo 3 caracteres")
//        String name,
//    @NotBlank(message = "O sobrenome não pode estar em branco")
//        @Size(min = 3, message = "O sobrenome deve ter no mínimo 3 caracteres")
//        String lastName,
//    @NotNull(message = "O endereço não pode ser nulo") @Valid AddressDTO address) {}
