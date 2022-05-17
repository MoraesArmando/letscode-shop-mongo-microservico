package br.com.armando.produto.service;

import br.com.armando.produto.dto.ProdutoRequest;
import br.com.armando.produto.dto.ProdutoResponse;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface ProdutoService {

     Flux<ProdutoResponse> listaProdutos();

     Mono<ProdutoResponse> criaProduto(ProdutoRequest produtoRequest);

     Mono<ProdutoResponse> obterPorCodigo(String codigo);

}
