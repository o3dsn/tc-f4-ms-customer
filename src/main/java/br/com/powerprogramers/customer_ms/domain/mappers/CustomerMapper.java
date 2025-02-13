package br.com.powerprogramers.customer_ms.domain.mappers;

import br.com.powerprogramers.customer_ms.domain.dto.CustomerDTO;
import br.com.powerprogramers.customer_ms.domain.entity.domain.Customer;
import br.com.powerprogramers.customer_ms.domain.entity.persistence.CustomerEntity;

public class CustomerMapper {
  public static Customer toDomain(CustomerDTO dto) {
    if (dto == null) {
      return null;
    }
    return new Customer(
        dto.getName(),
        dto.getLastName(),
        AddressMapper.toDomain(dto.getAddress()),
        CreditCardMapper.toDomain(dto.getCreditCard()));
  }

  public static CustomerEntity toEntity(Customer customer) {
    if (customer == null) {
      return null;
    }
    return new CustomerEntity(
        null,
        customer.getName(),
        customer.getLastName(),
        AddressMapper.toEntity(customer.getAddress()),
        CreditCardMapper.toEntity(customer.getCreditCard()));
  }

  public static CustomerDTO toDTO(CustomerEntity entity) {
    if (entity == null) {
      return null;
    }
    CustomerDTO dto = new CustomerDTO();
    dto.setId(entity.getId());
    dto.setName(entity.getName());
    dto.setLastName(entity.getLastName());
    dto.setAddress(AddressMapper.toDTO(entity.getAddress()));
    return dto;
  }
}
