package com.selling.system.export.shared.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.WebClient;

@Configuration
public class WebClientInit {

    @Bean
    
    WebClient.Builder webClientBuilder() {
        return WebClient.builder();
    }
}
