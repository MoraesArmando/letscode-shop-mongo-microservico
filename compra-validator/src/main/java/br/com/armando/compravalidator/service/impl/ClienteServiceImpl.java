package br.com.armando.compravalidator.service.impl;

import br.com.armando.compravalidator.dto.ClienteResponse;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

@Service
public class ClienteServiceImpl {

    public ClienteResponse getCliente(String identificador) {
        WebClient webClient = WebClient.create("http://localhost:8082");

        return webClient
                .get()
                .uri("/v1/cliente/{id}", identificador)
                .retrieve()
                .bodyToMono(ClienteResponse.class)
                .block();
    }
}


