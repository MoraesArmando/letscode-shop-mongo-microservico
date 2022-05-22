package br.com.armando.compravalidator.service;

import br.com.armando.compravalidator.dto.ClienteResponse;
import br.com.armando.compravalidator.dto.CompraResponse;
import ch.qos.logback.core.net.server.Client;
import lombok.RequiredArgsConstructor;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ReciverKadkaMessageImpl {
    public static final String KAFKA_GROUPID = "group-1";
    private final SendKafkaMessageImpl sendKafkaMessage;

    @KafkaListener(topics = SendKafkaMessageImpl.KAFKA_TOPIC, groupId = KAFKA_GROUPID)
    public  void listenTopic(CompraResponse compraResponse){

        compraResponse.setStatus("PROCESSADA");
        System.out.println("Compra processada:" + compraResponse.getCpf() + " " + compraResponse.getValorTotal());

    }
}
