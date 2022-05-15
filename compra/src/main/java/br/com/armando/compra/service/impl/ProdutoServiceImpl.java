package br.com.armando.compra.service.impl;

import br.com.armando.compra.dto.ClienteResponse;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

@Service
public class ProdutoServiceImpl {

    public static ProdutoResponse getClient(String identifier) {
        WebClient client = WebClient.create("http://localhost:8082");

        return client
                .get()
                .uri("/produto/{identifier}", identifier)
                .retrieve()
                .bodyToMono(ProdutoResponse.class)
                .block();
    }
}
