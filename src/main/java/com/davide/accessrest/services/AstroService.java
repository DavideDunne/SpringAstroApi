package com.davide.accessrest.services;

import com.davide.accessrest.json.AstroResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;

@Service
public class AstroService {
    private final RestTemplate template;
    private final WebClient client;
    public AstroService(@Qualifier("astroRestTemplate") RestTemplate template,@Qualifier("astroWebClient") WebClient client) {
        this.template = template;
        this.client = client;
    }
    public String getPeopleInSpace() {
        return this.template.getForObject("/astros.json", String.class);
    }
    public AstroResponse getAstroResponse() {
        return this.template.getForObject("/astros.json", AstroResponse.class);
    }
    public AstroResponse getAstroResponseAsync() {
        return this.client.get().uri("/astros.json")
                .accept(org.springframework.http.MediaType.APPLICATION_JSON)
                .retrieve()
                .bodyToMono(AstroResponse.class)
                .block();
    }
}
