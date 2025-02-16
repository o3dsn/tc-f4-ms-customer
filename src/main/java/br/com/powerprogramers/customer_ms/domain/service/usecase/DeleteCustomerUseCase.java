package br.com.powerprogramers.customer_ms.domain.service.usecase;

import br.com.powerprogramers.customer_ms.domain.exception.CustomerHasOpenOrdersException;
import br.com.powerprogramers.customer_ms.domain.exception.ExternalServiceException;
import br.com.powerprogramers.customer_ms.domain.gateway.MsOrderManagerClient;
import feign.FeignException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class DeleteCustomerUseCase {
  @Autowired MsOrderManagerClient msOrderManagerClient;

  public void execute(Long id) {
    try {
      boolean hasOpenOrders = msOrderManagerClient.getOpenOrdersByCustomerId(Long.toString(id));
      if (hasOpenOrders) {
        throw new CustomerHasOpenOrdersException();
      }
    } catch (FeignException e) {
      throw new ExternalServiceException("Error deleting the customer");
    }
  }
}
