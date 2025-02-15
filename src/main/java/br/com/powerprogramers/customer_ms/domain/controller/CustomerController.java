package br.com.powerprogramers.customer_ms.domain.controller;

import br.com.powerprogramers.customer_ms.domain.dto.CustomerDTO;
import br.com.powerprogramers.customer_ms.domain.service.CustomerService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/customers")
public class CustomerController {
  private final CustomerService customerService;

  @Autowired
  public CustomerController(CustomerService customerService) {
    this.customerService = customerService;
  }

  @PostMapping
  public ResponseEntity<Void> create(@RequestBody CustomerDTO dto) {
    customerService.create(dto);
    return ResponseEntity.ok().build();
  }

  @GetMapping
  public ResponseEntity<List<CustomerDTO>> findAll() {
    List<CustomerDTO> customers = customerService.findAll();
    return ResponseEntity.ok(customers);
  }

  @GetMapping("/{id}")
  public ResponseEntity<CustomerDTO> findById(@PathVariable Long id) {
    return ResponseEntity.ok(customerService.findById(id));
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<Void> delete(@PathVariable Long id) {
    customerService.delete(id);
    return ResponseEntity.noContent().build();
  }
}
