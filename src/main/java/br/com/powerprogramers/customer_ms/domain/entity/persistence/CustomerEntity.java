package br.com.powerprogramers.customer_ms.domain.entity.persistence;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity(name = "customers")
@Table
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CustomerEntity {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  private String name;
  private String lastName;

  @OneToOne(cascade = CascadeType.ALL)
  @JoinColumn(name = "address_id", referencedColumnName = "id")
  private AddressEntity address;

  @OneToOne(cascade = CascadeType.ALL)
  @JoinColumn(name = "credit_card_id", referencedColumnName = "id")
  private CreditCardEntity creditCard;
}
