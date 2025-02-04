package br.com.powerprogramers.customer_ms.client.viacep;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(url = "https://viacep.com.br/ws", name = "viacep")
public interface ViaCEPClient {
  @GetMapping("/{cep}/json/")
  ViaCEPAddress getEndereco(@PathVariable String cep);
}
