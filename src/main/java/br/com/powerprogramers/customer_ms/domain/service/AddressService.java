package br.com.powerprogramers.customer_ms.domain.service;

import br.com.powerprogramers.customer_ms.domain.entity.persistence.AddressEntity;
import br.com.powerprogramers.customer_ms.domain.service.usecase.AddressUseCase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AddressService {
  @Autowired private AddressUseCase addressUseCase;

  public AddressEntity getAddressByCEP(String cep) {
    if (cep == null || cep.isEmpty()) {
      return null;
    }

    var viaCEPAddress = addressUseCase.execute(cep);

    if (viaCEPAddress == null) {
      return null;
    }

    return AddressEntity.builder()
        .street(viaCEPAddress.logradouro())
        .number("")
        .neighborhood(viaCEPAddress.bairro())
        .city(viaCEPAddress.localidade())
        .state(viaCEPAddress.estado())
        .zipCode(viaCEPAddress.cep())
        .additionalInfo(viaCEPAddress.complemento())
        .build();
  }
}
