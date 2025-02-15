package br.com.powerprogramers.customer_ms.domain.service.usecase;

import br.com.powerprogramers.customer_ms.domain.exception.CustomerHasOpenOrdersException;
import br.com.powerprogramers.customer_ms.domain.gateway.MsOrderManagerClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class DeleteCustomerUseCase {
  @Autowired MsOrderManagerClient msOrderManagerClient;

  public void execute(Long id) {
    boolean hasOpenOrders = msOrderManagerClient.getOpenOrdersByCustomerId(Long.toString(id));
    if (hasOpenOrders) {
      throw new CustomerHasOpenOrdersException();
    }
  }
}
