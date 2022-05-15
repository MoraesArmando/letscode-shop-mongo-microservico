package br.com.armando.compra.dto;

import br.com.armando.produto.model.Produto;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class ProdutoResponse {

    private String codigo;
    private String nome;
    private Float preco;
    private Integer quantidade;

}
