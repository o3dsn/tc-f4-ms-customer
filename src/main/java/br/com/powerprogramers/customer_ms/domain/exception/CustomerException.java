package br.com.powerprogramers.customer_ms.domain.exception;

import java.time.Instant;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
@AllArgsConstructor
public class CustomerException extends RuntimeException {
  private final Instant timestamp;
  private final HttpStatus status;
  private final String message;
}
