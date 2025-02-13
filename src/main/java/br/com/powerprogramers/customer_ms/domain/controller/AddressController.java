package br.com.powerprogramers.customer_ms.domain.controller;

import br.com.powerprogramers.customer_ms.domain.entity.persistence.AddressEntity;
import br.com.powerprogramers.customer_ms.domain.service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/cep")
public class AddressController {
  private final AddressService addressService;

  @Autowired
  public AddressController(final AddressService addressService) {
    this.addressService = addressService;
  }

  @GetMapping("/{cep}")
  public ResponseEntity<AddressEntity> getCep(@PathVariable String cep) {
    return ResponseEntity.ok(addressService.getAddressByCEP(cep));
  }
}
