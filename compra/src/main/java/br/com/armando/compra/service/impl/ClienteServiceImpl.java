package br.com.armando.compra.service.impl;

import br.com.armando.compra.dto.ClienteResponse;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@Service
public class ClienteServiceImpl {

    WebClient webClient = WebClient.builder()
            .baseUrl("http://localhost:3000")
            .defaultHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
            .build();

    public Mono<ClienteResponse> getCliente(String identifier) {

        return  webClient
                .get()
                .uri("/v1/cliente/{identifier}", identifier)
                .header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
                .retrieve()
                .bodyToMono(ClienteResponse.class);
    }

}
