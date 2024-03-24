package com.davide.accessrest.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;

@Configuration
public class AppConfig {
    @Bean
    public RestTemplate astroRestTemplate(RestTemplateBuilder builder, @Value("${astro.baseUrl}") String baseUrl) {
        return builder.rootUri(baseUrl).build();
    }
    @Bean
    public WebClient astroWebClient(@Value("${astro.baseUrl}") String baseUrl) {
        return WebClient.create(baseUrl);
    }
    @Bean
    public RestTemplate anotherRestTemplate(RestTemplateBuilder builder) {
        return builder.rootUri("https://other.html").build();
    }
}
