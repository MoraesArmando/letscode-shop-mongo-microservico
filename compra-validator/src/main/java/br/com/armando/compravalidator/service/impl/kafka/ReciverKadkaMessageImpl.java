package br.com.armando.compravalidator.service.impl.kafka;

import br.com.armando.compravalidator.dto.CompraResponse;
import br.com.armando.compravalidator.service.impl.CompraValidadorServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ReciverKadkaMessageImpl {
    public static final String KAFKA_GROUPID = "group-1";
    public final CompraValidadorServiceImpl compraValidadorService;
    private final SendKafkaMessageImpl sendKafkaMessage;


    @KafkaListener(topics = SendKafkaMessageImpl.KAFKA_TOPIC, groupId = KAFKA_GROUPID)
    public  void listenTopic(CompraResponse compraResponse){
        sendKafkaMessage.sendMenssage(compraValidadorService.validationCompra(compraResponse));
    }
}
