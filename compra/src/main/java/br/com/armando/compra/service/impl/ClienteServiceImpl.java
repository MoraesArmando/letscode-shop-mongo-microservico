package br.com.armando.compra.service.impl;

import br.com.armando.compra.dto.ClienteResponse;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

@Service
public class ClienteServiceImpl {

    public ClienteResponse getClient(String identifier) {
        WebClient client = WebClient.create("http://localhost:8081");

        return (ClienteResponse) client
                .get()
                .uri("/cliente?cpf={identifier}", identifier)
                .retrieve()
                .bodyToMono(ClienteResponse.class)
                .block();
    }



}
