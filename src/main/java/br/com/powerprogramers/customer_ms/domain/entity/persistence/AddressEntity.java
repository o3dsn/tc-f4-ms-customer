package br.com.powerprogramers.customer_ms.domain.entity.persistence;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity(name = "addresses")
@Table
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AddressEntity {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  private String street;
  private String number;
  private String neighborhood;
  private String city;
  private String state;
  private String zipCode;
  private String additionalInfo;
}
