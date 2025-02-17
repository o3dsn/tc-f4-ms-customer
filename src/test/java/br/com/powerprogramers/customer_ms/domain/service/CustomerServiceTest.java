package br.com.powerprogramers.customer_ms.domain.service;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

import br.com.powerprogramers.customer_ms.domain.dto.AddressDTO;
import br.com.powerprogramers.customer_ms.domain.dto.CreditCardDTO;
import br.com.powerprogramers.customer_ms.domain.dto.CustomerDTO;
import br.com.powerprogramers.customer_ms.domain.entity.domain.Customer;
import br.com.powerprogramers.customer_ms.domain.entity.persistence.AddressEntity;
import br.com.powerprogramers.customer_ms.domain.entity.persistence.CreditCardEntity;
import br.com.powerprogramers.customer_ms.domain.entity.persistence.CustomerEntity;
import br.com.powerprogramers.customer_ms.domain.exception.CustomerNotFoundException;
import br.com.powerprogramers.customer_ms.domain.repository.CustomerRepository;
import br.com.powerprogramers.customer_ms.domain.service.usecase.CreateCustomerUseCase;
import br.com.powerprogramers.customer_ms.domain.service.usecase.DeleteCustomerUseCase;
import java.util.List;
import java.util.Optional;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class CustomerServiceTest {
  private AutoCloseable openMocks;

  @Mock private CustomerRepository customerRepository;
  @Mock private CreateCustomerUseCase createCustomerUseCase;
  @Mock private DeleteCustomerUseCase deleteCustomerUseCase;
  @InjectMocks private CustomerService customerService;

  private CustomerDTO customerDTO;
  private CustomerEntity customerEntity;

  @BeforeEach
  void setUp() {
    customerDTO = new CustomerDTO();
    customerDTO.setId(1L);
    customerDTO.setName("Joao");
    customerDTO.setLastName("Silva");
    customerDTO.setAddress(new AddressDTO());
    customerDTO.setCreditCard(new CreditCardDTO());

    customerEntity =
        CustomerEntity.builder()
            .id(1L)
            .name("Joao")
            .lastName("Silva")
            .address(new AddressEntity())
            .creditCard(new CreditCardEntity())
            .build();
  }

  @Test
  void shouldCreateCustomer() {
    when(customerRepository.save(any(CustomerEntity.class))).thenReturn(customerEntity);

    customerService.create(customerDTO);

    verify(createCustomerUseCase, times(1)).execute(any(Customer.class));
    verify(customerRepository, times(1)).save(any(CustomerEntity.class));
  }

  @Test
  void shouldFindAllCustomers() {
    when(customerRepository.findAll()).thenReturn(List.of(customerEntity));

    List<CustomerDTO> customers = customerService.findAll();

    assertEquals(1, customers.size());
    assertEquals("Joao", customers.get(0).getName());
  }

  @Test
  void shouldFindCustomerById() {
    when(customerRepository.findById(1L)).thenReturn(Optional.of(customerEntity));

    CustomerDTO foundCustomer = customerService.findById(1L);

    assertNotNull(foundCustomer);
    assertEquals("Joao", foundCustomer.getName());
  }

  @Test
  void shouldThrowExceptionWhenCustomerNotFound() {
    when(customerRepository.findById(99L)).thenReturn(Optional.empty());

    assertThrows(CustomerNotFoundException.class, () -> customerService.findById(99L));
  }

  @Test
  void shouldFindAddressByCustomerId() {
    when(customerRepository.findById(1L)).thenReturn(Optional.of(customerEntity));

    AddressDTO addressDTO = customerService.findAddressByCustomerId(1L);

    assertNotNull(addressDTO);
    verify(customerRepository, times(1)).findById(1L);
  }

  @Test
  void shouldThrowExceptionWhenAddressNotFoundForCustomerId() {
    when(customerRepository.findById(99L)).thenReturn(Optional.empty());

    assertThrows(
        CustomerNotFoundException.class, () -> customerService.findAddressByCustomerId(99L));

    verify(customerRepository, times(1)).findById(99L);
  }

  @Test
  void shouldDeleteCustomer() {
    doNothing().when(deleteCustomerUseCase).execute(1L);
    doNothing().when(customerRepository).deleteById(1L);

    customerService.delete(1L);

    verify(deleteCustomerUseCase, times(1)).execute(1L);
    verify(customerRepository, times(1)).deleteById(1L);
  }
}
