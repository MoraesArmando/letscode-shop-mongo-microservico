package br.com.armando.compra.dto;

import br.com.armando.compra.model.ProdutoCompra;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Builder
public class CompraRequest {

    private String cpf;
    private List<ProdutoCompra> produtoCompra;


}
