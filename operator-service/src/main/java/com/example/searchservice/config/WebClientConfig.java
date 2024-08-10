package com.example.searchservice.config;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.web.reactive.function.client.WebClient;

public class WebClientConfig {
    @Bean
    @LoadBalanced
    public WebClient.Builder webClient() {

        return WebClient.builder();
    }
}
