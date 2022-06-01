package br.com.armando.compra.kafka;

import br.com.armando.compra.dto.CompraResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class SendKafkaMessageImpl {

    private static final String KAFKA_TOPIC = "COMPRA_TOPICO";
    private final KafkaTemplate<String, CompraResponse> kafkaTemplate;

    public void sendMenssage(CompraResponse compraResponse){
        kafkaTemplate.send(KAFKA_TOPIC ,compraResponse);
    }
}
