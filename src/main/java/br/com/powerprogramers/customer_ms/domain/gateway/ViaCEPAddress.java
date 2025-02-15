package br.com.powerprogramers.customer_ms.domain.gateway;

public record ViaCEPAddress(
    String localidade,
    String cep,
    String logradouro,
    String complemento,
    String bairro,
    String cidade,
    String estado) {}
