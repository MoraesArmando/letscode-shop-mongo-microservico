package br.com.armando.cliente.controller.handler;


import br.com.armando.cliente.dto.ClienteRequest;
import br.com.armando.cliente.dto.ClienteResponse;
import br.com.armando.cliente.service.impl.ClienteServiceImpl;
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
public class ClienteHandler {

    private final ClienteServiceImpl clienteService;

    public Mono<ServerResponse> criaCliente(ServerRequest request) {
        final Mono<ClienteRequest> clienteRequest = request.bodyToMono(ClienteRequest.class);
        return ServerResponse
                .status(HttpStatus.CREATED)
                .contentType(MediaType.APPLICATION_JSON)
                .body(BodyInserters.fromPublisher(clienteRequest.flatMap(clienteService::criaCliente), ClienteResponse.class));
    }

    public Mono<ServerResponse> listaClientes(ServerRequest request) {
        return ServerResponse
                .status(HttpStatus.OK)
                .contentType(MediaType.APPLICATION_JSON)
                .body(clienteService.listaClientes(), ClienteResponse.class);
    }

    public Mono<ServerResponse> obterPorId(ServerRequest request) {
        final String id = request.pathVariable("id");
        return ServerResponse
                .status(HttpStatus.OK)
                .contentType(MediaType.APPLICATION_JSON)
                .body(clienteService.obterPorId(id), ClienteResponse.class);
    }

    public Mono<ServerResponse> obterPorCpf(ServerRequest request) {
        final String cpf = request.pathVariable("cpf");
        return ServerResponse
                .status(HttpStatus.OK)
                .contentType(MediaType.APPLICATION_JSON)
                .body(clienteService.obterPorCpf(cpf),ClienteResponse.class);
    }

}
