package br.com.powerprogramers.customer_ms.domain.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record AddressDTO(
    @NotBlank(message = "O nome da rua não pode estar em branco")
        @Size(min = 3, message = "O nome da rua deve ter no mínimo 3 caracteres")
        String street,
    @NotBlank(message = "O número não pode estar em branco") String number,
    @NotBlank(message = "O nome do bairro não pode estar em branco")
        @Size(min = 3, message = "O nome do bairro deve ter no mínimo 3 caracteres")
        String neighborhood,
    @NotBlank(message = "O nome da cidade não pode estar em branco")
        @Size(min = 3, message = "O nome da cidade deve ter no mínimo 3 caracteres")
        String city,
    @NotBlank(message = "O nome do estado não pode estar em branco")
        @Size(min = 3, message = "O nome do estado deve ter no mínimo 3 caracteres")
        String state,
    @NotBlank(message = "O CEP não pode estar em branco")
        @Size(min = 8, max = 8, message = "O CEP deve ter 8 caracteres")
        String zipCode,
    String additionalInfo) {}
