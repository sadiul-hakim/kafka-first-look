package org.kafkafirstlook.kafka;

import org.kafkafirstlook.pojo.DeliveryStatus;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class KafkaConsumer {
    private static final Logger LOGGER = LoggerFactory.getLogger(KafkaConsumer.class);
    @KafkaListener(topics = "hakimTopic",groupId = "my-group")
    public void consume(String message){
        LOGGER.info(STR."Message received: \{message}");
    }

    @KafkaListener(topics = "deliveryTopic",groupId = "my-group")
    public void status(DeliveryStatus message){
        LOGGER.info(STR."Status: \{message.message()} | \{message.zonedDateTime()}");
    }
}
