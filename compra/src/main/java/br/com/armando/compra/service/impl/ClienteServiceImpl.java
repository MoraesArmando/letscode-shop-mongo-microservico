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

    public Mono<ClienteResponse> getCliente(String identifier) {
        WebClient webClient = WebClient.builder()
                .baseUrl("http://localhost:8081")
                .defaultHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
                .build();


         Mono<ClienteResponse> cliente =  webClient
                .method(HttpMethod.GET)
                .uri("/cliente/{identifier}", identifier)
                .retrieve()
                .bodyToMono(ClienteResponse.class);

        return  cliente;

    }

}
