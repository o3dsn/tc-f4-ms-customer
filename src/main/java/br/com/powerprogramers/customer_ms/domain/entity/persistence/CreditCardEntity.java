package br.com.powerprogramers.customer_ms.domain.entity.persistence;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity(name = "credit_card")
@Table
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CreditCardEntity {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(length = 16)
  private String number;

  private String holderName;

  @Column(length = 2)
  private String expirationMonth;

  @Column(length = 4)
  private String expirationYear;

  private String brand;
}
