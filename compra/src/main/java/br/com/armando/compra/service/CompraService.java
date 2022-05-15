package br.com.armando.compra.service;

import br.com.armando.compra.dto.CompraRequest;
import br.com.armando.compra.dto.CompraResponse;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface CompraService {

    CompraResponse criarCompra(CompraRequest compraRequest);

    Page<CompraResponse> listaCpfPage(String cpf, Pageable pageable);

    Page<CompraResponse> listaTodasCompras(Pageable pageable);

}
