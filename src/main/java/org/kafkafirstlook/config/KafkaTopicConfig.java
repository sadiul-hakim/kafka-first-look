package org.kafkafirstlook.config;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;

@Configuration
public class KafkaTopicConfig {
    @Bean
    public NewTopic newTopic(){
        return TopicBuilder.name("hakimTopic")
                .build();
    }
    @Bean
    public NewTopic deliverTopic(){
        return TopicBuilder.name("deliveryTopic")
                .build();
    }
}
