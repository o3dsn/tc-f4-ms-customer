package br.com.powerprogramers.customer_ms.domain.mapper;

import br.com.powerprogramers.customer_ms.domain.dto.CustomerDTO;
import br.com.powerprogramers.customer_ms.domain.entity.domain.Customer;
import br.com.powerprogramers.customer_ms.domain.entity.persistence.CustomerEntity;

public class CustomerMapper {
  public static Customer toDomain(CustomerDTO dto) {
    return new Customer(dto.name(), dto.lastName(), AddressMapper.toDomain(dto.address()));
  }

  public static CustomerEntity toEntity(Customer customer) {
    return new CustomerEntity(
        null,
        customer.getName(),
        customer.getLastName(),
        AddressMapper.toEntity(customer.getAddress()));
  }
}
