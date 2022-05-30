package br.com.armando.compravalidator.service;

import br.com.armando.compravalidator.dto.ClienteResponse;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

@Service
public class ClienteServiceImpl {

    public ClienteResponse getCliente(String cpf) {
        WebClient webClient = WebClient.create();

        return webClient
                .get()
                .uri("/v1/produto/{cpf}", cpf)
                .retrieve()
                .bodyToMono(ClienteResponse.class)
                .block();
    }
}


