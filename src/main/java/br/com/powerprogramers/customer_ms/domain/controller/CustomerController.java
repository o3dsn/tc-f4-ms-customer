package br.com.powerprogramers.customer_ms.domain.controller;

import br.com.powerprogramers.customer_ms.domain.dto.AddressDTO;
import br.com.powerprogramers.customer_ms.domain.dto.CustomerDTO;
import br.com.powerprogramers.customer_ms.domain.service.CustomerService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/customers")
@Tag(name = "Customer API", description = "Gerenciamento de Clientes")
public class CustomerController {
  private final CustomerService customerService;

  @Autowired
  public CustomerController(CustomerService customerService) {
    this.customerService = customerService;
  }

  @PostMapping
  @Operation(summary = "Criar um novo cliente", description = "Cria um novo cliente no sistema")
  @ApiResponse(responseCode = "200", description = "Cliente criado com sucesso")
  public ResponseEntity<Void> create(@RequestBody CustomerDTO dto) {
    customerService.create(dto);
    return ResponseEntity.ok().build();
  }

  @GetMapping
  @Operation(
      summary = "Listar todos os clientes",
      description = "Retorna uma lista de todos os clientes cadastrados")
  @ApiResponse(responseCode = "200", description = "Lista de clientes retornada com sucesso")
  public ResponseEntity<List<CustomerDTO>> findAll() {
    List<CustomerDTO> customers = customerService.findAll();
    return ResponseEntity.ok(customers);
  }

  @GetMapping("/{id}")
  @Operation(
      summary = "Buscar cliente por ID",
      description = "Retorna os detalhes do cliente correspondente ao ID informado")
  @ApiResponses({
    @ApiResponse(responseCode = "200", description = "Cliente encontrado"),
    @ApiResponse(responseCode = "404", description = "Cliente não encontrado")
  })
  public ResponseEntity<CustomerDTO> findById(@PathVariable Long id) {
    return ResponseEntity.ok(customerService.findById(id));
  }

  @GetMapping("/{id}/address")
  @Operation(
      summary = "Buscar endereço do cliente",
      description = "Retorna o endereço do cliente pelo ID")
  @ApiResponses({
    @ApiResponse(responseCode = "200", description = "Endereço encontrado"),
    @ApiResponse(responseCode = "404", description = "Cliente não encontrado")
  })
  public ResponseEntity<AddressDTO> findAddressByCustomerId(@PathVariable Long id) {
    return ResponseEntity.ok(customerService.findAddressByCustomerId(id));
  }

  @DeleteMapping("/{id}")
  @Operation(summary = "Deletar cliente", description = "Remove um cliente do sistema pelo ID")
  @ApiResponses({
    @ApiResponse(responseCode = "204", description = "Cliente deletado com sucesso"),
    @ApiResponse(responseCode = "404", description = "Cliente não encontrado")
  })
  public ResponseEntity<Void> delete(@PathVariable Long id) {
    customerService.delete(id);
    return ResponseEntity.noContent().build();
  }
}
