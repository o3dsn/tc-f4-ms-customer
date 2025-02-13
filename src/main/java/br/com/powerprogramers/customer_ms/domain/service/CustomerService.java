package br.com.powerprogramers.customer_ms.domain.service;

import br.com.powerprogramers.customer_ms.domain.dto.CustomerDTO;
import br.com.powerprogramers.customer_ms.domain.entity.domain.Customer;
import br.com.powerprogramers.customer_ms.domain.entity.persistence.CustomerEntity;
import br.com.powerprogramers.customer_ms.domain.exception.CustomerNotFoundException;
import br.com.powerprogramers.customer_ms.domain.mappers.CustomerMapper;
import br.com.powerprogramers.customer_ms.domain.repository.CustomerRepository;
import br.com.powerprogramers.customer_ms.domain.service.usecase.CustomerUseCase;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerService {
  private final CustomerUseCase customerUseCase;
  private final CustomerRepository customerRepository;

  @Autowired
  public CustomerService(CustomerUseCase customerUseCase, CustomerRepository customerRepository) {
    this.customerUseCase = customerUseCase;
    this.customerRepository = customerRepository;
  }

  public void create(CustomerDTO dto) {
    Customer customer = CustomerMapper.toDomain(dto);
    customerUseCase.validate(customer);
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
}
