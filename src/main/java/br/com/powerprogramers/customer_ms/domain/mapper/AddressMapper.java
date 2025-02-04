package br.com.powerprogramers.customer_ms.domain.mapper;

import br.com.powerprogramers.customer_ms.domain.dto.AddressDTO;
import br.com.powerprogramers.customer_ms.domain.entity.domain.Address;
import br.com.powerprogramers.customer_ms.domain.entity.persistence.AddressEntity;

public class AddressMapper {
  public static Address toDomain(AddressDTO dto) {
    return new Address(
        dto.street(),
        dto.number(),
        dto.neighborhood(),
        dto.city(),
        dto.state(),
        dto.zipCode(),
        dto.additionalInfo());
  }

  public static AddressEntity toEntity(Address address) {
    return new AddressEntity(
        null,
        address.getStreet(),
        address.getNumber(),
        address.getNeighborhood(),
        address.getCity(),
        address.getState(),
        address.getZipCode(),
        address.getAdditionalInfo());
  }
}
