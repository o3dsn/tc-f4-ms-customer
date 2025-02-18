package br.com.powerprogramers.customer_ms.domain.controller;

import br.com.powerprogramers.customer_ms.domain.entity.persistence.AddressEntity;
import br.com.powerprogramers.customer_ms.domain.service.AddressService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/cep")
@Tag(name = "Address API", description = "Consulta de endereços pelo CEP")
public class AddressController {
  private final AddressService addressService;

  @Autowired
  public AddressController(final AddressService addressService) {
    this.addressService = addressService;
  }

  @GetMapping("/{cep}")
  @Operation(
      summary = "Buscar endereço pelo CEP",
      description = "Retorna os detalhes do endereço correspondente ao CEP informado.")
  @ApiResponse(responseCode = "200", description = "Endereço encontrado com sucesso")
  public ResponseEntity<AddressEntity> getCep(@PathVariable String cep) {
    return ResponseEntity.ok(addressService.getAddressByCEP(cep));
  }
}
