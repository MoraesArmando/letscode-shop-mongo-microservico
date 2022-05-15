package br.com.armando.produto.model;

import br.com.armando.produto.dto.ProdutoRequest;
import br.com.armando.produto.dto.ProdutoResponse;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Getter
@Setter
@Builder
@Document
public class Produto {

    @Id
    private String id;
    private String codigo;
    private String nome;
    private Float preco;
    private Integer quantidade;

    public static Produto converteRequest(ProdutoRequest produtoRequest){
        return Produto.builder()
                .codigo(produtoRequest.getCodigo())
                .nome(produtoRequest.getName())
                .preco(produtoRequest.getPrice())
                .quantidade(produtoRequest.getQuantidade())
                .build();
    }

    public static Produto converteResponse(ProdutoResponse produtoResponse){
        return Produto.builder()
                .codigo(produtoResponse.getCodigo())
                .nome(produtoResponse.getName())
                .preco(produtoResponse.getPrice())
                .quantidade(produtoRequest.getQuantidade())
                .build();
    }

}
