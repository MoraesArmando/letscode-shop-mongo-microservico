package br.com.armando.compra.service.impl;

import br.com.armando.compra.dto.ClienteResponse;
import br.com.armando.compra.dto.CompraRequest;
import br.com.armando.compra.dto.CompraResponse;
import br.com.armando.compra.dto.ProdutoResponse;
import br.com.armando.compra.model.Compra;
import br.com.armando.compra.model.ProdutoCompra;
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
    private final ProdutoServiceImpl produtoService;
    private final ClienteServiceImpl clienteService;
    private final SendKafkaMessageImpl sendKafkaMessage;

    @Override
    public CompraResponse criarCompra(CompraRequest compraRequest) {
        ClienteResponse clienteResponse = clienteService.getClient(compraRequest.getCpf());
        Compra compra = Compra.builder()
                .cpf(clienteResponse.getCpf())
                .dataCompra(LocalDateTime.now())
                .valorTotal(132.0F)
//                .valorTotal(calculaValorProduto(compraRequest))
                .produtoCompra(compraRequest.getProdutoCompra())
                .build();

        compraRepository.save(compra);
        CompraResponse compraResponse = CompraResponse.convert(compra);
        sendKafkaMessage.sendMenssage(compraResponse);
        return compraResponse;
    }

    private Float calculaValorProduto(CompraRequest compraRequest) {
        float valorTotal = 0;
        for (ProdutoCompra p :
                compraRequest.getProdutoCompra()) {
            ProdutoResponse produtoResponse = produtoService.getProduto(p.getCodigoProduto());
            valorTotal += produtoResponse.getPreco() * p.getQuantidade();
        }
        return valorTotal;
    }

    @Override
    public Page<CompraResponse> listaCpfPage(String cpf, Pageable pageable) {
        return compraRepository.findByCpf(cpf, pageable).map(CompraResponse::convert);
    }

    @Override
    public Page<CompraResponse> listaTodasCompras(Pageable pageable) {
        return compraRepository.findAll(pageable).map(CompraResponse::convert);
    }
}
