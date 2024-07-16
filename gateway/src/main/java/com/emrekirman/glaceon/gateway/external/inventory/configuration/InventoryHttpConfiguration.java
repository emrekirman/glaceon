package com.emrekirman.glaceon.gateway.external.inventory.configuration;

import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

import java.time.Duration;

@Configuration
public class InventoryHttpConfiguration {

    @Bean("inventoryServiceRestTemplate")
    public RestTemplate restTemplate() {
        Duration duration = Duration.ofSeconds(40L);
        return new RestTemplateBuilder()
                .setReadTimeout(duration)
                .setConnectTimeout(duration)
                .build();
    }
}
