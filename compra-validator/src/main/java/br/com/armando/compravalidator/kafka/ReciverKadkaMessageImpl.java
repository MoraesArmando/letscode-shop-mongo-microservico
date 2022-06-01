package br.com.armando.compravalidator.kafka;

import br.com.armando.compravalidator.dto.CompraResponse;
import br.com.armando.compravalidator.service.impl.CompraValidadorServiceImpl;
import lombok.RequiredArgsConstructor;
import org.apache.kafka.common.network.Send;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ReciverKadkaMessageImpl {

    public static final String KAFKA_GROUPID = "group-1";
    private static final String KAFKA_TOPIC_PENDENTE = "COMPRA_TOPICO_PENDENTE";

    public final CompraValidadorServiceImpl compraValidadorService;
    private final SendKafkaMessageImpl sendKafkaMessage;


    @KafkaListener(topics = KAFKA_TOPIC_PENDENTE, groupId = KAFKA_GROUPID)
    public  void listenTopic(CompraResponse compraResponse){
        sendKafkaMessage.sendMenssage(compraValidadorService.validationCompra(compraResponse));
    }
}
