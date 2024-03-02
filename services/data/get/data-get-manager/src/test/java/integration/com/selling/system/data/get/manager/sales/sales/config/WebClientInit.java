package com.selling.system.data.get.manager.sales.sales.config;

import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.web.reactive.function.client.WebClient;

@TestConfiguration
public class WebClientInit {

    @Bean
    WebClient.Builder webClientBuilder() {
        return WebClient.builder();
    }
}