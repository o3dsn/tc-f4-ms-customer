package br.com.powerprogramers.customer_ms.domain.service;

import br.com.powerprogramers.customer_ms.domain.dto.CustomerDTO;
import br.com.powerprogramers.customer_ms.domain.entity.domain.Customer;
import br.com.powerprogramers.customer_ms.domain.entity.persistence.CustomerEntity;
import br.com.powerprogramers.customer_ms.domain.mapper.CustomerMapper;
import br.com.powerprogramers.customer_ms.domain.repository.CustomerRepository;
import br.com.powerprogramers.customer_ms.domain.service.usecase.CustomerUseCase;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerService {
  @Autowired private CustomerUseCase customerUseCase;
  @Autowired private CustomerRepository customerRepository;

  public void create(CustomerDTO dto) {
    Customer customer = CustomerMapper.toDomain(dto);
    customerUseCase.validate(customer);
    CustomerEntity customerEntity = CustomerMapper.toEntity(customer);
    customerRepository.save(customerEntity);
  }

  public List<CustomerEntity> findAll() {
    return customerRepository.findAll();
  }

  public CustomerEntity findById(Long id) {
    return customerRepository.findById(id).orElse(null);
  }
}
