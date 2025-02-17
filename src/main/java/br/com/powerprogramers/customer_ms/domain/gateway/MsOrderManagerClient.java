package br.com.powerprogramers.customer_ms.domain.gateway;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "tc-f4-ms-order-manager")
public interface MsOrderManagerClient {
  @GetMapping("/order/open_orders/{customerId}")
  Boolean getOpenOrdersByCustomerId(@PathVariable Long customerId);
}
