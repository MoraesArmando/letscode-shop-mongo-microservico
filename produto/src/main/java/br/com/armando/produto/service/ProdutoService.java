package br.com.armando.produto.service;

import br.com.armando.produto.dto.ProdutoRequest;
import br.com.armando.produto.dto.ProdutoResponse;
import br.com.armando.produto.model.Produto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ProdutoService {

    public Page<ProdutoResponse> listaProdutos(Pageable pageable);

    public ProdutoResponse criaProduto(ProdutoRequest produtoRequest);

    public ProdutoResponse obterPorCodigo(String codigo);

    public void deleteProduto(String codigo);
}
