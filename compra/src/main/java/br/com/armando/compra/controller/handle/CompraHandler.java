package br.com.armando.compra.controller.handle;

import br.com.armando.compra.dto.CompraRequest;
import br.com.armando.compra.dto.CompraResponse;
import br.com.armando.compra.service.impl.CompraServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

@RequiredArgsConstructor
@Component
public class CompraHandler {

    private final CompraServiceImpl compraService;

    public Mono<ServerResponse> listaCompras(ServerRequest request) {
        return ServerResponse.ok()
                .contentType(MediaType.APPLICATION_JSON)
                .body(compraService.listaTodasCompras(), CompraResponse.class);
    }

    public Mono<ServerResponse> obterPorCpf(ServerRequest request) {
        final String cpf = request.pathVariable("cpf");
        return ServerResponse.ok()
                .contentType(MediaType.APPLICATION_JSON)
                .body(compraService.listaCpfPage(cpf), CompraResponse.class);
    }

    public Mono<ServerResponse> criaCompra(ServerRequest request) {
        final Mono<CompraRequest> compraRequest = request.bodyToMono(CompraRequest.class);
        return ServerResponse
                .status(HttpStatus.CREATED)
                .contentType(MediaType.APPLICATION_JSON)
                .body(BodyInserters.fromPublisher(compraRequest.flatMap(compraService::criarCompra), CompraResponse.class));
    }

}
