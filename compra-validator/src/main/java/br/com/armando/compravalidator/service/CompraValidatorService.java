package br.com.armando.compravalidator.service;

import br.com.armando.compravalidator.dto.CompraRequest;
import br.com.armando.compravalidator.dto.CompraResponse;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.Optional;

public interface CompraValidatorService {
    CompraResponse validationCompra(CompraResponse compraResponse);
    Flux<CompraResponse> listaCpfPage(String cpf);

    Flux<CompraResponse> listaTodasCompras();

}
