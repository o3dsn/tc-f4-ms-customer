Feature: Address API

  Scenario: Buscar endereço por CEP com sucesso
    Given que o CEP "22070012" existe
    When eu faço uma requisição GET para addresses "/cep/22070012"
    Then o status da resposta deve ser 200
    And o JSON da resposta deve conter "street" igual a "Avenida Nossa Senhora de Copacabana" para addresses