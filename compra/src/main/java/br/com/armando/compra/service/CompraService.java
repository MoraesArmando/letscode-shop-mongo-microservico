package br.com.armando.compra.service;

import br.com.armando.compra.dto.CompraRequest;
import br.com.armando.compra.dto.CompraResponse;
import reactor.core.publisher.Mono;

public interface CompraService {

    Mono<CompraResponse> criarCompra(CompraRequest compraRequest);

}
