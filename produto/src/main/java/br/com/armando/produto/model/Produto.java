package br.com.armando.produto.model;

import br.com.armando.produto.dto.ProdutoRequest;
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
    private Float preco;
    private Integer quantidade;

    public static Produto converteRequest(ProdutoRequest produtoRequest){
        return Produto.builder()
                .codigo(produtoRequest.getCodigo())
                .preco(produtoRequest.getPreco())
                .quantidade(produtoRequest.getQuantidade())
                .build();
    }

}
