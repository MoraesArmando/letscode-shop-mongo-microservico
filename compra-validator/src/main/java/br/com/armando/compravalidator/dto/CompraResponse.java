package br.com.armando.compravalidator.dto;

import br.com.armando.compravalidator.model.Compra;
import br.com.armando.compravalidator.model.ProdutoCompra;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Getter
@Setter
@Builder
public class CompraResponse {

    private String cpf;
    private LocalDateTime dataCompra;
    private Float valorTotal;
    private String status;
    private List<ProdutoCompraResponse> produtoCompra;


    public static CompraResponse convert(Compra compra) {
        return CompraResponse.builder()
                .cpf(compra.getCpf())
                .dataCompra(compra.getDataCompra())
                .valorTotal(compra.getValorTotal())
                .status(compra.getStatus())
                .produtoCompra(compra.getProdutoCompra().stream().map(ProdutoCompraResponse::convert).collect(Collectors.toList()))
                .build();
    }
}
