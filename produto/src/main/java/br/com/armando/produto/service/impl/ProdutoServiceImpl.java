package br.com.armando.produto.service.impl;

import br.com.armando.produto.dto.ProdutoRequest;
import br.com.armando.produto.dto.ProdutoResponse;
import br.com.armando.produto.model.Produto;
import br.com.armando.produto.repository.ProdutoRepository;
import br.com.armando.produto.service.ProdutoService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ProdutoServiceImpl implements ProdutoService {

    private final ProdutoRepository produtoRepository;

    @Override
    public Page<ProdutoResponse> listaProdutos(Pageable pageable) {
        return produtoRepository.findAll(pageable).map(ProdutoResponse::converte);
    }

    @Override
    public ProdutoResponse criaProduto(ProdutoRequest produtoRequest) {
        Produto produto = Produto.converteRequest(produtoRequest);
        return ProdutoResponse.converte(produtoRepository.save(produto));
    }

    @Override
    public ProdutoResponse obterPorCodigo(String codigo) {
        return ProdutoResponse.converte(produtoRepository.findByCodigo(codigo));
    }

    @Override
    public void deleteProduto(String codigo) {
        Produto produto = Produto.converteResponse(obterPorCodigo(codigo));
        produtoRepository.delete(produto);
    }
}
