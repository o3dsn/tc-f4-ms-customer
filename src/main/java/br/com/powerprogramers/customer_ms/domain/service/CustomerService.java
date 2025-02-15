package br.com.powerprogramers.customer_ms.domain.service;

import br.com.powerprogramers.customer_ms.domain.dto.CustomerDTO;
import br.com.powerprogramers.customer_ms.domain.entity.domain.Customer;
import br.com.powerprogramers.customer_ms.domain.entity.persistence.CustomerEntity;
import br.com.powerprogramers.customer_ms.domain.exception.CustomerNotFoundException;
import br.com.powerprogramers.customer_ms.domain.mappers.CustomerMapper;
import br.com.powerprogramers.customer_ms.domain.repository.CustomerRepository;
import br.com.powerprogramers.customer_ms.domain.service.usecase.CreateCustomerUseCase;
import br.com.powerprogramers.customer_ms.domain.service.usecase.DeleteCustomerUseCase;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerService {
  private final CustomerRepository customerRepository;
  private final CreateCustomerUseCase createCustomerUseCase;
  private final DeleteCustomerUseCase deleteCustomerUseCase;

  @Autowired
  public CustomerService(
      CustomerRepository customerRepository,
      CreateCustomerUseCase createCustomerUseCase,
      DeleteCustomerUseCase deleteCustomerUseCase) {
    this.customerRepository = customerRepository;
    this.createCustomerUseCase = createCustomerUseCase;
    this.deleteCustomerUseCase = deleteCustomerUseCase;
  }

  public void create(CustomerDTO dto) {
    Customer customer = CustomerMapper.toDomain(dto);
    createCustomerUseCase.execute(customer);
    CustomerEntity customerEntity = CustomerMapper.toEntity(customer);
    customerRepository.save(customerEntity);
  }

  public List<CustomerDTO> findAll() {
    return customerRepository.findAll().stream()
        .map(CustomerMapper::toDTO)
        .collect(Collectors.toList());
  }

  public CustomerDTO findById(Long id) {
    CustomerEntity entity =
        customerRepository.findById(id).orElseThrow(() -> new CustomerNotFoundException(id));
    return CustomerMapper.toDTO(entity);
  }

  public void delete(Long id) {
    deleteCustomerUseCase.execute(id);
    customerRepository.deleteById(id);
  }
}
