package br.com.armando.produto.service.impl;

import br.com.armando.produto.dto.ProdutoRequest;
import br.com.armando.produto.dto.ProdutoResponse;
import br.com.armando.produto.model.Produto;
import br.com.armando.produto.repository.ProdutoRepository;
import br.com.armando.produto.service.ProdutoService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
public class ProdutoServiceImpl implements ProdutoService {

    private final ProdutoRepository produtoRepository;

    @Override
    public Flux<ProdutoResponse> listaProdutos() {
        return produtoRepository.findAll().map(ProdutoResponse::converte);
    }

    @Override
    public Mono<ProdutoResponse> criaProduto(ProdutoRequest produtoRequest) {
        Produto produto = Produto.converteRequest(produtoRequest);
        return produtoRepository.insert(produto).map(ProdutoResponse::converte);
    }

    @Override
    public Mono<ProdutoResponse> obterPorCodigo(String codigo) {
        return produtoRepository.findByCodigo(codigo).map(ProdutoResponse::converte);
    }

}
