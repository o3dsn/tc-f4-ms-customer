package br.com.powerprogramers.customer_ms.domain.service.usecase;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

import br.com.powerprogramers.customer_ms.domain.entity.domain.Address;
import br.com.powerprogramers.customer_ms.domain.entity.domain.CreditCard;
import br.com.powerprogramers.customer_ms.domain.entity.domain.Customer;
import br.com.powerprogramers.customer_ms.domain.exception.CreateCustomerUseCaseException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class CreateCustomerUseCaseTest {

  private CreateCustomerUseCase createCustomerUseCase;
  private Customer validCustomer;

  @BeforeEach
  void setUp() {
    createCustomerUseCase = new CreateCustomerUseCase();

    validCustomer = new Customer();
    validCustomer.setAddress(new Address());
    validCustomer.setCreditCard(new CreditCard());
  }

  @Test
  void shouldCreateCustomerSuccessfully() {
    assertDoesNotThrow(() -> createCustomerUseCase.execute(validCustomer));
  }

  @Test
  void shouldThrowExceptionWhenCustomerIsNull() {
    assertThrows(
        CreateCustomerUseCaseException.class,
        () -> createCustomerUseCase.execute(null),
        "Customer must not be null");
  }

  @Test
  void shouldThrowExceptionWhenCustomerAddressIsEmpty() {
    validCustomer.setAddress(null);

    assertThrows(
        CreateCustomerUseCaseException.class,
        () -> createCustomerUseCase.execute(validCustomer),
        "Customer address cannot be empty");
  }

  @Test
  void shouldThrowExceptionWhenCustomerCreditCardIsEmpty() {
    validCustomer.setCreditCard(null);

    assertThrows(
        CreateCustomerUseCaseException.class,
        () -> createCustomerUseCase.execute(validCustomer),
        "Customer credit card cannot be empty");
  }
}
