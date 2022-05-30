package br.com.armando.compravalidator.service;

import br.com.armando.compra.dto.CompraRequest;
import br.com.armando.compra.dto.CompraResponse;
import br.com.armando.compravalidator.dto.CompraRequest;
import br.com.armando.compravalidator.dto.CompraResponse;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface CompraService {

    CompraResponse criarCompra(CompraResponse compraResponse);

    CompraResponse listaCpfPage(String cpf);

   CompraResponse listaTodasCompras();

}
