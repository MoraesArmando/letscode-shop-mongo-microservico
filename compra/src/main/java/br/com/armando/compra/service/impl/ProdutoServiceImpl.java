package br.com.armando.compra.service.impl;

import br.com.armando.compra.dto.ProdutoResponse;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

@Service
public class ProdutoServiceImpl {

    public ProdutoResponse getProduto(String identifier) {
        WebClient produto = WebClient.create("http://localhost:8082");

        return (ProdutoResponse) produto
                .get()
                .uri("/produto?codigo={identifier}", identifier)
                .retrieve()
                .bodyToMono(ProdutoResponse.class)
                .block();
    }
}
