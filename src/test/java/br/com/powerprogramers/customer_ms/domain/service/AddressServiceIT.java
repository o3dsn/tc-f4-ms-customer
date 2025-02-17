package br.com.powerprogramers.customer_ms.domain.service;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

import br.com.powerprogramers.customer_ms.domain.entity.persistence.AddressEntity;
import br.com.powerprogramers.customer_ms.domain.gateway.ViaCEPAddress;
import br.com.powerprogramers.customer_ms.domain.service.usecase.AddressUseCase;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class AddressServiceIT {

  @Mock private AddressUseCase addressUseCase;

  @InjectMocks private AddressService addressService;

  @Test
  void shouldReturnAddressEntityWhenCepIsValid() {
    // Simulando uma resposta real
    String localidade = "Rio de Janeiro";
    String cep = "22070012";
    String logradouro = "Avenida Nossa Senhora de Copacabana";
    String complemento = "de 1170 ao fim - lado par";
    String bairro = "Copacabana";
    String cidade = "Rio de Janeiro";
    String estado = "Rio de Janeiro";

    ViaCEPAddress viaCEPAddress =
        new ViaCEPAddress(localidade, cep, logradouro, complemento, bairro, cidade, estado);

    when(addressUseCase.execute(cep)).thenReturn(viaCEPAddress);

    AddressEntity result = addressService.getAddressByCEP(cep);

    assertNotNull(result);
    assertEquals(logradouro, result.getStreet());
    assertEquals(bairro, result.getNeighborhood());
    assertEquals(cidade, result.getCity());
    assertEquals(estado, result.getState());
    assertEquals(cep, result.getZipCode());
  }

  @Test
  void shouldReturnNullWhenCepIsNull() {
    AddressEntity result = addressService.getAddressByCEP(null);
    assertNull(result);
  }

  @Test
  void shouldReturnNullWhenCepIsEmpty() {
    AddressEntity result = addressService.getAddressByCEP("");
    assertNull(result);
  }

  @Test
  void shouldReturnNullWhenViaCepReturnsNull() {
    String cep = "01001000";

    when(addressUseCase.execute(cep)).thenReturn(null);

    AddressEntity result = addressService.getAddressByCEP(cep);

    assertNull(result);
  }
}
