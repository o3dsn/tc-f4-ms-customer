package br.com.powerprogramers.customer_ms.domain.repository;

import br.com.powerprogramers.customer_ms.domain.entity.persistence.CustomerEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<CustomerEntity, Long> {}
