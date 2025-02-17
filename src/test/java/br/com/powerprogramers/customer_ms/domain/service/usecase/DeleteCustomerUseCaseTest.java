package br.com.powerprogramers.customer_ms.domain.service.usecase;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;

import br.com.powerprogramers.customer_ms.domain.exception.CustomerHasOpenOrdersException;
import br.com.powerprogramers.customer_ms.domain.exception.ExternalServiceException;
import br.com.powerprogramers.customer_ms.domain.gateway.MsOrderManagerClient;
import feign.FeignException;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class DeleteCustomerUseCaseTest {
  @Mock private MsOrderManagerClient msOrderManagerClient;

  @InjectMocks private DeleteCustomerUseCase deleteCustomerUseCase;

  private final Long customerId = 1L;

  @Test
  void shouldDeleteCustomerWhenNoOpenOrders() {
    when(msOrderManagerClient.getOpenOrdersByCustomerId(customerId)).thenReturn(false);

    assertDoesNotThrow(() -> deleteCustomerUseCase.execute(customerId));

    verify(msOrderManagerClient, times(1)).getOpenOrdersByCustomerId(customerId);
  }

  @Test
  void shouldThrowCustomerHasOpenOrdersExceptionWhenCustomerHasOpenOrders() {
    when(msOrderManagerClient.getOpenOrdersByCustomerId(customerId)).thenReturn(true);

    assertThrows(
        CustomerHasOpenOrdersException.class, () -> deleteCustomerUseCase.execute(customerId));

    verify(msOrderManagerClient, times(1)).getOpenOrdersByCustomerId(customerId);
  }

  @Test
  void shouldThrowExternalServiceExceptionWhenFeignClientFails() {
    when(msOrderManagerClient.getOpenOrdersByCustomerId(customerId))
        .thenThrow(FeignException.class);

    assertThrows(ExternalServiceException.class, () -> deleteCustomerUseCase.execute(customerId));

    verify(msOrderManagerClient, times(1)).getOpenOrdersByCustomerId(customerId);
  }
}
