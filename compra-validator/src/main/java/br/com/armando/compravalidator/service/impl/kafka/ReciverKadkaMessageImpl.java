package br.com.armando.compravalidator.service.impl.kafka;

import br.com.armando.compravalidator.dto.CompraResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ReciverKadkaMessageImpl {
    public static final String KAFKA_GROUPID = "group-1";

    @KafkaListener(topics = SendKafkaMessageImpl.KAFKA_TOPIC, groupId = KAFKA_GROUPID)
    public  void listenTopic(CompraResponse compraResponse){


    }
}
