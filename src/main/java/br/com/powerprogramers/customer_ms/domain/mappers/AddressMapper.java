package br.com.powerprogramers.customer_ms.domain.mappers;

import br.com.powerprogramers.customer_ms.domain.dto.AddressDTO;
import br.com.powerprogramers.customer_ms.domain.entity.domain.Address;
import br.com.powerprogramers.customer_ms.domain.entity.persistence.AddressEntity;

public class AddressMapper {
  public static Address toDomain(AddressDTO dto) {
    if (dto == null) {
      return null;
    }
    return new Address(
        dto.getStreet(),
        dto.getNumber(),
        dto.getNeighborhood(),
        dto.getCity(),
        dto.getState(),
        dto.getZipCode(),
        dto.getAdditionalInfo());
  }

  public static AddressEntity toEntity(Address address) {
    if (address == null) {
      return null;
    }
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

  public static AddressDTO toDTO(AddressEntity entity) {
    if (entity == null) {
      return null;
    }
    AddressDTO dto = new AddressDTO();
    dto.setStreet(entity.getStreet());
    dto.setNumber(entity.getNumber());
    dto.setNeighborhood(entity.getNeighborhood());
    dto.setCity(entity.getCity());
    dto.setState(entity.getState());
    dto.setZipCode(entity.getZipCode());
    dto.setAdditionalInfo(entity.getAdditionalInfo());
    return dto;
  }
}
