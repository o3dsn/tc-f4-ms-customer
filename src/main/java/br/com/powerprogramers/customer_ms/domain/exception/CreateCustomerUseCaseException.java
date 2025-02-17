package br.com.powerprogramers.customer_ms.domain.exception;

import java.time.Instant;
import org.springframework.http.HttpStatus;

public class CreateCustomerUseCaseException extends CustomerException {
  public CreateCustomerUseCaseException(String message) {
    super(Instant.now(), HttpStatus.BAD_REQUEST, message);
  }
}
