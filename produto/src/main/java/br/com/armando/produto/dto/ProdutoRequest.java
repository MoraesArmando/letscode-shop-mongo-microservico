package br.com.armando.produto.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class ProdutoRequest {

    private String codigo;
    private Float preco;
    private Integer quantidade;


}
