package br.com.powerprogramers.customer_ms.domain.exception;

import java.time.Instant;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public class CustomerNotFoundException extends CustomerException {
  public CustomerNotFoundException(Long id) {
    super(Instant.now(), HttpStatus.NOT_FOUND, "Customer not found with ID: " + id);
  }
}
