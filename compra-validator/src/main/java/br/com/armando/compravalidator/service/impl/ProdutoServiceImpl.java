package br.com.armando.compravalidator.service.impl;

import br.com.armando.compravalidator.dto.ProdutoResponse;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

@Service
public class ProdutoServiceImpl {

    public ProdutoResponse getProduto(String identificador) {
        WebClient webClient = WebClient.create("http://localhost:8081");

        return webClient
                .get()
                .uri("/v1/produtos/{codigo}", identificador)
                .retrieve()
                .bodyToMono(ProdutoResponse.class)
                .block();
    }
}
