package br.com.armando.compra.dto;

import br.com.armando.compra.model.Compra;
import br.com.armando.compra.model.ProdutoCompra;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@Builder
public class CompraResponse {

    private String cpf;
    private LocalDateTime dataCompra;
    private Float valorTotal;
    private String status;
    private List<ProdutoCompra> produtoCompra;

    public static CompraResponse convert(Compra compra){
        return CompraResponse.builder()
                .cpf(compra.getCpf())
                .dataCompra(compra.getDataCompra())
                .valorTotal(compra.getValorTotal())
                .produtoCompra(compra.getProdutoCompra())
                .status(compra.getStatus())
                .build();
    }
}
