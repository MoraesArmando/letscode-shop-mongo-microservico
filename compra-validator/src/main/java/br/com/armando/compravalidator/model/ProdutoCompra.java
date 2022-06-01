package br.com.armando.compravalidator.model;

import br.com.armando.compravalidator.dto.ProdutoCompraResponse;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class ProdutoCompra {

    private String codigoProduto;
    private Integer quantidade;

    public static ProdutoCompra convert(ProdutoCompraResponse produtoCompraResponse) {
        return ProdutoCompra.builder()
                .codigoProduto(produtoCompraResponse.getCodigoProduto())
                .quantidade(produtoCompraResponse.getQuantidade())
                .build();
    }
}
