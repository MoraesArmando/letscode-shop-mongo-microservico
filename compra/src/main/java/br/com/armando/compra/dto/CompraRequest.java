package br.com.armando.compra.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Builder
public class CompraRequest {

    private String cpf;
    private List<ProdutoCompraResponse> produtoCompra;


}
