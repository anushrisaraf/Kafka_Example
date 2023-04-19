package com.example.demo.Kafka;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class Producer {


    private static final Logger LOGGER = LoggerFactory.getLogger(Producer.class);

    public Producer(KafkaTemplate<String, String> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    private KafkaTemplate<String,String>  kafkaTemplate;

    public void sendMessage(String message)
    {
        LOGGER.info(String.format("Message sent %s",message));
        kafkaTemplate.send("Java_Study_Topics",message);
    }




}
