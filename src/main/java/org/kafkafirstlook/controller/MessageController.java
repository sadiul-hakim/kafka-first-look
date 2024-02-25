package org.kafkafirstlook.controller;

import org.kafkafirstlook.kafka.KafkaProducer;
import org.kafkafirstlook.pojo.DeliveryStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.ZonedDateTime;
import java.util.Collections;

@RestController
@RequestMapping("/api/v-1/message")
public class MessageController {
    private final KafkaProducer kafkaProducer;

    public MessageController(KafkaProducer kafkaProducer) {
        this.kafkaProducer = kafkaProducer;
    }

    @GetMapping("/publish")
    public ResponseEntity<?> publish(@RequestParam String message){
        kafkaProducer.sendMessage("hakimTopic",message);
        return ResponseEntity.ok(Collections.singletonMap("message","Message successfully send!"));
    }
    @GetMapping("/update-status")
    public ResponseEntity<?> delivery(@RequestParam String message){

        var status = new DeliveryStatus(message, ZonedDateTime.now());

        kafkaProducer.updateStatus("deliveryTopic",status);
        return ResponseEntity.ok(Collections.singletonMap("message","Message successfully send!"));
    }
}
