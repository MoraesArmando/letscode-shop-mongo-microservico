package br.com.armando.produto.dto;

import br.com.armando.produto.model.Produto;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class ProdutoResponse {

    private String codigo;
    private Float preco;
    private Integer quantidade;

    public static ProdutoResponse converte(Produto produto){
        return  ProdutoResponse.builder()
                .codigo(produto.getCodigo())
                .preco(produto.getPreco())
                .quantidade(produto.getQuantidade())
                .build();
    }

}
