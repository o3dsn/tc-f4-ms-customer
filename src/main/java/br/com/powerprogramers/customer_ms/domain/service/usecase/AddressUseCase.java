package br.com.powerprogramers.customer_ms.domain.service.usecase;

import br.com.powerprogramers.customer_ms.domain.gateway.ViaCEPAddress;
import br.com.powerprogramers.customer_ms.domain.gateway.ViaCEPClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class AddressUseCase {
  @Autowired ViaCEPClient viacepClient;

  public ViaCEPAddress execute(String cep) {
    return viacepClient.getEndereco(cep);
  }
}
