package br.com.powerprogramers.customer_ms.domain.exception;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

  @ExceptionHandler({
    CreateCustomerUseCaseException.class,
    CustomerNotFoundException.class,
    ExternalServiceException.class,
    CustomerHasOpenOrdersException.class
  })
  public ResponseEntity<Map<String, Object>> handleCustomExceptions(RuntimeException ex) {
    Map<String, Object> response = new HashMap<>();
    HttpStatus status = HttpStatus.INTERNAL_SERVER_ERROR;
    String message = ex.getMessage();

    if (ex instanceof CreateCustomerUseCaseException customException) {
      status = customException.getStatus();
    }

    if (ex instanceof CustomerNotFoundException customException) {
      status = customException.getStatus();
    }

    if (ex instanceof ExternalServiceException customException) {
      status = customException.getStatus();
    }

    if (ex instanceof CustomerHasOpenOrdersException customException) {
      status = customException.getStatus();
    }

    response.put("timestamp", LocalDateTime.now());
    response.put("status", status.value());
    response.put("error", status.getReasonPhrase());
    response.put("message", message);

    return ResponseEntity.status(status.value()).body(response);
  }
}
