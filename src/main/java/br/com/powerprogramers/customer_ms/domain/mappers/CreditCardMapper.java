package br.com.powerprogramers.customer_ms.domain.mappers;

import br.com.powerprogramers.customer_ms.domain.dto.CreditCardDTO;
import br.com.powerprogramers.customer_ms.domain.entity.domain.CreditCard;
import br.com.powerprogramers.customer_ms.domain.entity.persistence.CreditCardEntity;

public class CreditCardMapper {
  public static CreditCard toDomain(CreditCardDTO dto) {
    if (dto == null) {
      return null;
    }
    return new CreditCard(
        dto.getNumber(),
        dto.getHolderName(),
        dto.getExpirationMonth(),
        dto.getExpirationYear(),
        dto.getBrand());
  }

  public static CreditCardEntity toEntity(CreditCard creditCard) {
    if (creditCard == null) {
      return null;
    }

    return new CreditCardEntity(
        null,
        creditCard.getNumber(),
        creditCard.getHolderName(),
        creditCard.getExpirationMonth(),
        creditCard.getExpirationYear(),
        creditCard.getBrand());
  }

  public static CreditCardDTO toDTO(CreditCardEntity entity) {
    if (entity == null) {
      return null;
    }

    CreditCardDTO dto = new CreditCardDTO();
    dto.setNumber(entity.getNumber());
    dto.setHolderName(entity.getHolderName());
    dto.setExpirationMonth(entity.getExpirationMonth());
    dto.setExpirationYear(entity.getExpirationYear());
    dto.setBrand(entity.getBrand());
    return dto;
  }
}
