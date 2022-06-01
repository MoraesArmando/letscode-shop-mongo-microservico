package br.com.armando.compra.dto;

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
    private List<ProdutoCompraResponse> produtoCompra;


}
