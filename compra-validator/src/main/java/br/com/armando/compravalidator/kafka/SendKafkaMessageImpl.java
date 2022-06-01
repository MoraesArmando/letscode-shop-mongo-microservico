package br.com.armando.compravalidator.kafka;

import br.com.armando.compravalidator.dto.CompraResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class SendKafkaMessageImpl {
    private static final String KAFKA_TOPIC_PROCESSADA = "COMPRA_TOPICO_PROCESSADA";

    private final KafkaTemplate<String, CompraResponse> kafkaTemplate;

    public void sendMenssage(CompraResponse compraResponse){
        kafkaTemplate.send(KAFKA_TOPIC_PROCESSADA ,compraResponse);
    }
}
