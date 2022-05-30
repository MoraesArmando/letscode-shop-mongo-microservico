package br.com.armando.cliente.controller.router;

import br.com.armando.cliente.controller.handler.ClienteHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;

import static org.springframework.web.reactive.function.server.RequestPredicates.*;


@Configuration
public class ClienteRouter {

    @Bean
    RouterFunction<ServerResponse> router(ClienteHandler clienteHandler) {

        return RouterFunctions.route(GET("/v1/cliente/{cpf}").and(accept(MediaType.APPLICATION_JSON)), clienteHandler::obterPorCpf)
                .andRoute(POST("/v1/cliente").and(accept(MediaType.APPLICATION_JSON)), clienteHandler::criaCliente)
                .andRoute(GET("/v1/clientes").and(accept(MediaType.APPLICATION_JSON)), clienteHandler::listaClientes)
                .andRoute(GET("/v1/cliente/{id}").and(accept(MediaType.APPLICATION_JSON)), clienteHandler::obterPorId);
    }
}
