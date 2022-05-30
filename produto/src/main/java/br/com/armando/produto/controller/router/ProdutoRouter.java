package br.com.armando.produto.controller.router;

import br.com.armando.produto.controller.handler.ProdutoHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;

import static org.springframework.web.reactive.function.server.RequestPredicates.GET;
import static org.springframework.web.reactive.function.server.RequestPredicates.POST;
import static org.springframework.web.reactive.function.server.RequestPredicates.accept;


@Configuration
public class ProdutoRouter {

    @Bean
    RouterFunction<ServerResponse> router(ProdutoHandler produtoHandler) {

        return RouterFunctions.route(GET("/v1/produtos/{codigo}").and(accept(MediaType.APPLICATION_JSON)), produtoHandler::obterPorCodigo)
                .andRoute(POST("/v1/produtos").and(accept(MediaType.APPLICATION_JSON)), produtoHandler::criaProduto)
                .andRoute(GET("/v/1/produtos").and(accept(MediaType.APPLICATION_JSON)), produtoHandler::listaProdutos);
    }
}
