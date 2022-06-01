package br.com.armando.compra.controller.router;

import br.com.armando.compra.controller.handler.CompraHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;

import static org.springframework.web.reactive.function.server.RequestPredicates.POST;
import static org.springframework.web.reactive.function.server.RequestPredicates.accept;

@Configuration
public class CompraRouter {

    @Bean
    RouterFunction<ServerResponse> router(CompraHandler compraHandler) {
        return RouterFunctions.route(POST("/v1/compra").and(accept(MediaType.APPLICATION_JSON)), compraHandler::criarCompra);
    }

}
