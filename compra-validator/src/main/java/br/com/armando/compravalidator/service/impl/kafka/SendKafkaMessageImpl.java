package br.com.armando.compravalidator.service.impl.kafka;

import br.com.armando.compravalidator.dto.CompraResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class SendKafkaMessageImpl {

    public static final String KAFKA_TOPIC = "COMPRA_PROCESSADA";

    private final KafkaTemplate<String, CompraResponse> kafkaTemplate;

    public void sendMenssage(CompraResponse compraResponse){
        kafkaTemplate.send(KAFKA_TOPIC ,compraResponse);
    }
}
