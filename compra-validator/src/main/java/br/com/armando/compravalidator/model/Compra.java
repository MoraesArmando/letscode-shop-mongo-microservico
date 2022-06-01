package br.com.armando.compravalidator.model;

import br.com.armando.compravalidator.dto.CompraRequest;
import br.com.armando.compravalidator.dto.CompraResponse;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import reactor.core.publisher.Mono;

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



}
