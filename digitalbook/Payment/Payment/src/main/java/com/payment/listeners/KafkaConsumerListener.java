package com.payment.listeners;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import com.payment.entities.Payment;


@Service
public class KafkaConsumerListener {

    private static final String TOPIC = "test-topic";

//    @KafkaListener(topics = TOPIC, groupId="group_id", containerFactory = "userKafkaListenerFactory")
//    public void consumeJson(Payment payment) {
//        System.out.println("Consumed JSON Message: " + payment);
//    }
    
}