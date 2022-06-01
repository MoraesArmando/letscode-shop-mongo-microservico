package br.com.armando.compravalidator.dto;

import br.com.armando.compravalidator.model.ProdutoCompra;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class ProdutoCompraResponse {
    private String codigoProduto;
    private Integer quantidade;


    public static ProdutoCompraResponse convert(ProdutoCompra produtoCompra) {
        return ProdutoCompraResponse.builder()
                .codigoProduto(produtoCompra.getCodigoProduto())
                .quantidade(produtoCompra.getQuantidade())
                .build();
    }
}
