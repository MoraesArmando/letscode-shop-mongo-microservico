package br.com.armando.produto.dto;

import br.com.armando.produto.model.Produto;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class ProdutoRequest {

    private String codigo;
    private String nome;
    private Float preco;
    private Integer quantidade;

    public  static  ProdutoRequest converte(Produto produto){
        return ProdutoRequest.builder()
                .codigo(produto.getCodigo())
                .nome(produto.getNome())
                .preco(produto.getPreco())
                .quantidade(produto.getQuantidade())
                .build();
    }

}
