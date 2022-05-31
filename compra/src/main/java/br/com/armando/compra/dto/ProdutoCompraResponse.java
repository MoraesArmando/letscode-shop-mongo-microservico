package br.com.armando.compra.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class ProdutoCompraResponse {
    private String codigoProduto;
    private Integer quantidade;

}
