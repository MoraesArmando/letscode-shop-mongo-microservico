package br.com.armando.compra.service.impl;

import br.com.armando.compra.dto.ClienteResponse;
import br.com.armando.compra.dto.CompraRequest;
import br.com.armando.compra.dto.CompraResponse;
import br.com.armando.compra.model.Compra;
import br.com.armando.compra.repository.CompraRepository;
import br.com.armando.compra.service.CompraService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class CompraServiceImpl implements CompraService {

    private final CompraRepository compraRepository;
    private final SendKafkaMessageImpl sendKafkaMessage;
    private final ProdutoServiceImpl produtoService;
    private final ClienteServiceImpl clienteService;

    @Override
    public Mono<CompraResponse> criarCompra(CompraRequest compraRequest) {

//      Mono<ClienteResponse> clienteResponse = clienteService.getCliente(compraRequest.getCpf());

        Compra compra = Compra.builder()
                .cpf(compraRequest.getCpf())
                .dataCompra(LocalDateTime.now())
                .valorTotal(0F)
                .status("PENDENTE")
                .produtoCompra(compraRequest.getProdutoCompra())
                .build();

        sendKafkaMessage.sendMenssage(CompraResponse.convert(compra));
        return compraRepository.save(compra).map(CompraResponse::convert);
    }

    @Override
    public Mono<CompraResponse> listaCpfPage(String cpf) {
        return compraRepository.findByCpf(cpf);
    }

    @Override
    public Flux<CompraResponse> listaTodasCompras( ) {
        return compraRepository.findAll().map(CompraResponse::convert);
    }

}
