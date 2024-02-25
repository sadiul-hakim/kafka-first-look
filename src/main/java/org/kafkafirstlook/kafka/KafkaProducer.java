package org.kafkafirstlook.kafka;

import org.kafkafirstlook.pojo.DeliveryStatus;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;

@Service
public class KafkaProducer {
    private static final Logger LOGGER = LoggerFactory.getLogger(KafkaProducer.class);
    private final KafkaTemplate<String,String> kafkaTemplate;
    private final KafkaTemplate<String, DeliveryStatus> deliveryTemplate;

    public KafkaProducer(KafkaTemplate<String, String> kafkaTemplate, KafkaTemplate<String, DeliveryStatus> deliveryTemplate) {
        this.kafkaTemplate = kafkaTemplate;
        this.deliveryTemplate = deliveryTemplate;
    }

    public void sendMessage(String topicName,String message){
        LOGGER.info(STR."Send message \{message}");
        kafkaTemplate.send(topicName,message);
    }

    public void updateStatus(String topicName,DeliveryStatus deliveryStatus){

        Message<DeliveryStatus> message = MessageBuilder
                .withPayload(deliveryStatus)
                .setHeader(KafkaHeaders.TOPIC, topicName)
                .build();

        LOGGER.info(STR."Send message \{message}");
        deliveryTemplate.send(message);
    }
}
