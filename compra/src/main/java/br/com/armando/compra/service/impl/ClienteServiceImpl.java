package br.com.armando.compra.service.impl;

import br.com.armando.compra.dto.ClienteResponse;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@Service
public class ClienteServiceImpl {

    WebClient webClient = WebClient.create()
            .baseUrl("http://localhost:8082")
            .defaultHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
            .build();

    public Mono<ClienteResponse> getCliente(String cpf) {
        return webClient
                .get()
                .uri("/v1/cliente/{cpf}", cpf)
                .retrieve()
                .bodyToMono(ClienteResponse.class);
    }

}
