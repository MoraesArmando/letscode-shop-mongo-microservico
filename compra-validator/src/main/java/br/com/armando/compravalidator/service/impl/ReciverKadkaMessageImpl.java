package br.com.armando.compravalidator.service.impl;

import br.com.armando.compravalidator.dto.CompraResponse;
import br.com.armando.compravalidator.service.CompraService;
import lombok.RequiredArgsConstructor;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ReciverKadkaMessageImpl {
    public static final String KAFKA_GROUPID = "group-1";
    private final CompraService compraService;

    @KafkaListener(topics = SendKafkaMessageImpl.KAFKA_TOPIC, groupId = KAFKA_GROUPID)
    public  void listenTopic(CompraResponse compraResponse){

        compraService.criarCompra(compraResponse);
        System.out.println("Compra processada:" + compraResponse.getCpf() + " " + compraResponse.getValorTotal());

    }
}
