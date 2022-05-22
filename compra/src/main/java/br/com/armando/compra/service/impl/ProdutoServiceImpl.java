package br.com.armando.compra.service.impl;

import br.com.armando.compra.dto.ProdutoResponse;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@Service
public class ProdutoServiceImpl {

    public ProdutoResponse getProduto(String identifier) {
        WebClient webClient = WebClient.create("http://localhost:8082");

        return webClient.get()
                .uri("/produto/{identifier}", identifier)
                .header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
                .retrieve()
                .bodyToMono(ProdutoResponse.class)
                .block();
    }
}
