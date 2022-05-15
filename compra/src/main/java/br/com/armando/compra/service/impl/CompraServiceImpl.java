package br.com.armando.compra.service.impl;

import br.com.armando.compra.dto.CompraRequest;
import br.com.armando.compra.dto.CompraResponse;
import br.com.armando.compra.model.Compra;
import br.com.armando.compra.repository.CompraRepository;
import br.com.armando.compra.service.CompraService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class CompraServiceImpl implements CompraService {

    private final CompraRepository compraRepository;

    @Override
    public CompraResponse criarCompra(CompraRequest compraRequest) {
        Compra compra = Compra.converteRequest(compraRequest);
        compra.setDataCompra(LocalDateTime.now());
        compra.setValorTotal(calculaValorProduto(compraRequest));

        compraRepository.save(compra);
        return CompraResponse.convert(compra);
    }

    private Float calculaValorProduto(CompraRequest compraRequest) {
    return null;
    }

    @Override
    public Page<CompraResponse> listaCpfPage(String cpf, Pageable pageable) {
        return compraRepository.findByCpf(cpf, pageable);
    }

    @Override
    public Page<CompraResponse> listaTodasCompras(Pageable pageable) {
        return compraRepository.findAll(pageable).map(CompraResponse::convert);
    }
}
