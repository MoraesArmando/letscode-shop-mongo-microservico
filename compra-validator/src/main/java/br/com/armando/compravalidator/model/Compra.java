package br.com.armando.compravalidator.model;

import br.com.armando.compravalidator.dto.CompraRequest;
import br.com.armando.compravalidator.dto.CompraResponse;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Getter
@Setter
@Builder
@Document
public class Compra {

    @Id
    private String id;
    private String cpf;
    private LocalDateTime dataCompra;
    private Float valorTotal;
    private String status;
    private List<ProdutoCompra> produtoCompra;


    public static Compra converteRequest(CompraRequest compraRequest) {
        return Compra.builder()
                .cpf(compraRequest.getCpf())
                .produtoCompra(compraRequest.getProdutoCompra().stream().map(ProdutoCompra::convert).collect(Collectors.toList()))
                .build();
    }

    public static Compra converteResponse(CompraResponse compraResponse){
        return Compra.builder()
                .cpf(compraResponse.getCpf())
                .dataCompra(compraResponse.getDataCompra())
                .valorTotal(compraResponse.getValorTotal())
                .status(compraResponse.getStatus())
                .produtoCompra(compraResponse.getProdutoCompra().stream().map(ProdutoCompra::convert).collect(Collectors.toList()))
                .build();
    }

}
