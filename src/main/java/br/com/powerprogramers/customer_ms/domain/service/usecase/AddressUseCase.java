package br.com.powerprogramers.customer_ms.domain.service.usecase;

import br.com.powerprogramers.customer_ms.client.viacep.ViaCEPAddress;
import br.com.powerprogramers.customer_ms.client.viacep.ViaCEPClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class AddressUseCase {
  @Autowired ViaCEPClient viacepClient;

  public ViaCEPAddress execute(String cep) {
    return viacepClient.getEndereco(cep);
  }
}
