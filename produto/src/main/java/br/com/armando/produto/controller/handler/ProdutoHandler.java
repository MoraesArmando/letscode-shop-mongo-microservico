package br.com.armando.produto.controller.handler;

import br.com.armando.produto.dto.ProdutoRequest;
import br.com.armando.produto.dto.ProdutoResponse;
import br.com.armando.produto.service.impl.ProdutoServiceImpl;
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
public class ProdutoHandler {

    private final ProdutoServiceImpl produtoService;

    public Mono<ServerResponse> criaProduto(ServerRequest request) {
        final Mono<ProdutoRequest> produtoRequest = request.bodyToMono(ProdutoRequest.class);
        return ServerResponse
                .status(HttpStatus.CREATED)
                .contentType(MediaType.APPLICATION_JSON)
                .body(BodyInserters.fromPublisher(produtoRequest.flatMap(produtoService::criaProduto), ProdutoResponse.class));
    }

    public Mono<ServerResponse> listaProdutos(ServerRequest request) {
        return ServerResponse
                .status(HttpStatus.OK)
                .contentType(MediaType.APPLICATION_JSON)
                .body(produtoService.listaProdutos(), ProdutoResponse.class);
    }

    public Mono<ServerResponse> obterPorCodigo(ServerRequest request) {
        String codigo = request.pathVariable("codigo");
        return ServerResponse
                .status(HttpStatus.OK)
                .contentType(MediaType.APPLICATION_JSON)
                .body(produtoService.obterPorCodigo(codigo), ProdutoResponse.class);
    }
}
