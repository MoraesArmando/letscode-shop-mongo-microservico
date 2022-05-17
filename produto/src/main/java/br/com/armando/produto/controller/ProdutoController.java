package br.com.armando.produto.controller;

import br.com.armando.produto.dto.ProdutoRequest;
import br.com.armando.produto.dto.ProdutoResponse;
import br.com.armando.produto.service.impl.ProdutoServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/produto")
@RequiredArgsConstructor
public class ProdutoController {

    private final ProdutoServiceImpl produtoService;

    @PostMapping
    public Mono<ProdutoResponse> criaProduto(@RequestBody ProdutoRequest produtoRequest) {
        return produtoService.criaProduto(produtoRequest);
    }

    @GetMapping
    public Flux<ProdutoResponse> listaProdutos() {
        return produtoService.listaProdutos();
    }

    @GetMapping("/{codigo}")
    public Mono<ProdutoResponse> obterPorCodigo(@PathVariable String codigo) {
        return produtoService.obterPorCodigo(codigo);
    }

}
