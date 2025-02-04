package br.com.powerprogramers.customer_ms.domain.controller;

import br.com.powerprogramers.customer_ms.domain.dto.CustomerDTO;
import br.com.powerprogramers.customer_ms.domain.entity.persistence.CustomerEntity;
import br.com.powerprogramers.customer_ms.domain.service.CustomerService;
import jakarta.validation.Valid;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/customers")
public class CustomerController {
  @Autowired private CustomerService customerService;

  @PostMapping
  public ResponseEntity<Void> create(@RequestBody @Valid CustomerDTO dto) {
    customerService.create(dto);
    return ResponseEntity.ok().build();
  }

  @GetMapping
  public ResponseEntity<List<CustomerEntity>> findAll() {
    return ResponseEntity.ok(customerService.findAll());
  }

  @GetMapping("/{id}")
  public ResponseEntity<CustomerEntity> findById(@PathVariable Long id) {
    return ResponseEntity.ok(customerService.findById(id));
  }
}
