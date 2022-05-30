package br.com.armando.compra.service.impl;

import br.com.armando.compra.dto.CompraRequest;
import br.com.armando.compra.dto.CompraResponse;
import br.com.armando.compra.service.CompraService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class CompraServiceImpl implements CompraService {
    private final SendKafkaMessageImpl sendKafkaMessage;

    @Override
    public Mono<CompraResponse> criarCompra(CompraRequest compraRequest) {

        CompraResponse compraResponse = CompraResponse.builder()
                .cpf(compraRequest.getCpf())
                .dataCompra(LocalDateTime.now())
                .valorTotal(0F)
                .status("PENDENTE")
                .produtoCompra(compraRequest.getProdutoCompra())
                .build();

        sendKafkaMessage.sendMenssage(compraResponse);

        return null;
    }

    @Override
    public Mono<CompraResponse> listaCpfPage(String cpf) {
        return null;
    }

    @Override
    public Flux<CompraResponse> listaTodasCompras() {
        return null;
    }

    public static CompraResponse getCompra(String identificador) {
        WebClient webClient = WebClient.create("http://localhost:80823");

        return webClient
                .get()
                .uri("/cliente/{id}", identificador)
                .retrieve()
                .bodyToMono(ClienteDTO.class)
                .block();
    }


}
