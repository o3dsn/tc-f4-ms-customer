package br.com.powerprogramers.customer_ms.domain.exception;

import java.time.Instant;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public class CustomerHasOpenOrdersException extends CustomerException {
  public CustomerHasOpenOrdersException() {
    super(Instant.now(), HttpStatus.CONFLICT, "Customer has open orders and cannot be deleted.");
  }
}
