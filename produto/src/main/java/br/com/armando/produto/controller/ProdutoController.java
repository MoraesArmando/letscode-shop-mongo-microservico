package br.com.armando.produto.controller;

import br.com.armando.produto.dto.ProdutoRequest;
import br.com.armando.produto.dto.ProdutoResponse;
import br.com.armando.produto.service.impl.ProdutoServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/produto")
@RequiredArgsConstructor
public class ProdutoController {

    private final ProdutoServiceImpl produtoService;

    @PostMapping
    public ProdutoResponse criaProduto(@RequestBody ProdutoRequest produtoRequest){
        return produtoService.criaProduto(produtoRequest);
    }

    @GetMapping
    public Page<ProdutoResponse> listaProdutos(@PageableDefault Pageable pageable){
        return produtoService.listaProdutos(pageable);
    }

    @GetMapping("/{codigo}")
    public ProdutoResponse obterPorCodigo(@PathVariable String codigo){
        return produtoService.obterPorCodigo(codigo);
    }

}
