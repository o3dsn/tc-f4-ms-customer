package br.com.powerprogramers.customer_ms.domain.service.usecase;

import br.com.powerprogramers.customer_ms.domain.entity.domain.Customer;
import br.com.powerprogramers.customer_ms.domain.exception.CreateCustomerUseCaseException;
import org.springframework.stereotype.Component;
import org.springframework.util.ObjectUtils;

@Component
public class CreateCustomerUseCase {
  public void execute(Customer customer) {
    if (customer == null) {
      throw new CreateCustomerUseCaseException("Customer must not be null");
    }

    if (ObjectUtils.isEmpty(customer.getAddress())) {
      throw new CreateCustomerUseCaseException("Customer address cannot be empty");
    }

    if (ObjectUtils.isEmpty(customer.getCreditCard())) {
      throw new CreateCustomerUseCaseException("Customer credit card cannot be empty");
    }
  }
}
