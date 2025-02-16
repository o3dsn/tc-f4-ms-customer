package br.com.powerprogramers.customer_ms.domain.exception;

import java.time.Instant;
import org.springframework.http.HttpStatus;

public class ExternalServiceException extends CustomerException {
  public ExternalServiceException(final String message) {
    super(Instant.now(), HttpStatus.SERVICE_UNAVAILABLE, message);
  }
}
