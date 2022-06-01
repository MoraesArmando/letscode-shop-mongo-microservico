package br.com.armando.compra.service.impl;

import br.com.armando.compra.dto.CompraRequest;
import br.com.armando.compra.dto.CompraResponse;
import br.com.armando.compra.kafka.SendKafkaMessageImpl;
import br.com.armando.compra.service.CompraService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class CompraServiceImpl implements CompraService {
    private final SendKafkaMessageImpl sendKafkaMessage;


    @Override
    public Mono<CompraResponse> criarCompra(CompraRequest compraRequest) {

        CompraResponse compraResponse = CompraResponse.builder()
                .cpf(compraRequest.getCpf())
                .dataCompra(LocalDateTime.now())
                .valorTotal(0F)
                .status("PENDENTE")
                .produtoCompra(compraRequest.getProdutoCompra())
                .build();

        sendKafkaMessage.sendMenssage(compraResponse);

        return Mono.just(compraResponse);
    }


}
