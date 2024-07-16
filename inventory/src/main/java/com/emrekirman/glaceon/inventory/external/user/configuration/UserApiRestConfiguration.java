package com.emrekirman.glaceon.inventory.external.user.configuration;

import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

import java.time.Duration;

@Configuration
public class UserApiRestConfiguration {

    @Bean("userApiRestTemplate")
    public RestTemplate restTemplate() {

        Duration duration = Duration.ofSeconds(40L);

        return new RestTemplateBuilder()
                .setConnectTimeout(duration)
                .setReadTimeout(duration)
                .build();
    }
}
