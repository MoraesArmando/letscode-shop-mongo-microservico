package br.com.armando.compravalidator.service.impl;

import br.com.armando.compravalidator.dto.CompraResponse;
import br.com.armando.compravalidator.model.Compra;
import br.com.armando.compravalidator.repository.CompraRepository;
import br.com.armando.compravalidator.service.CompraService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CompraServiceImpl implements CompraService {

    private final SendKafkaMessageImpl sendKafkaMessage;
    private final CompraRepository compraRepository;
    private final ProdutoServiceImpl produtoService;
    private final ClienteServiceImpl clienteService;

    @Override
    public CompraResponse criarCompra(CompraResponse compraResponse) {

        Compra compra = Compra.converteResponse(compraResponse);
        compra.setStatus("PROCESSADA");

        compraRepository.save(compra);
        return CompraResponse.converte(compra);
    }

    @Override
    public CompraResponse listaCpfPage(String cpf) {
        return compraRepository.findByCpf(cpf);
    }

    @Override
    public CompraResponse listaTodasCompras() {
        return null;
    }

}
