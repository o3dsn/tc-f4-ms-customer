package br.com.powerprogramers.customer_ms.domain.service.usecase;

import br.com.powerprogramers.customer_ms.domain.gateway.ViaCEPAddress;
import br.com.powerprogramers.customer_ms.domain.gateway.ViaCEPClient;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class AddressUseCaseTest {

  @Mock private ViaCEPClient viacepClient;

  @InjectMocks private AddressUseCase addressUseCase;

  @Test
  void shouldReturnViaCEPAddressWhenCepIsValid() {
    String localidade = "Rio de Janeiro";
    String cep = "22070012";
    String logradouro = "Avenida Nossa Senhora de Copacabana";
    String complemento = "de 1170 ao fim - lado par";
    String bairro = "Copacabana";
    String cidade = "Rio de Janeiro";
    String estado = "Rio de Janeiro";
    ViaCEPAddress mockAddress =
        new ViaCEPAddress(localidade, cep, logradouro, complemento, bairro, cidade, estado);

    when(viacepClient.getEndereco(cep)).thenReturn(mockAddress);

    ViaCEPAddress result = addressUseCase.execute(cep);

    assertNotNull(result);
    assertEquals(logradouro, result.logradouro());
    assertEquals(bairro, result.bairro());
    assertEquals(localidade, result.localidade());
    assertEquals(estado, result.estado());
    assertEquals(cep, result.cep());
    assertEquals(complemento, result.complemento());
    assertEquals(cidade, result.cidade());
  }

  @Test
  void shouldReturnNullWhenCepIsInvalid() {
    String invalidCep = "00000000";

    when(viacepClient.getEndereco(invalidCep)).thenReturn(null);

    ViaCEPAddress result = addressUseCase.execute(invalidCep);

    assertNull(result);
  }
}
