Feature: Customer API
  
  Scenario: Buscar todos os clientes
    When eu faço uma requisição GET para customers "/customers"
    Then o status da resposta deve ser 200 para customers