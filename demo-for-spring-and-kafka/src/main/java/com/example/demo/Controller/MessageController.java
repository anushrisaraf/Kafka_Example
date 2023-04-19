package com.example.demo.Controller;

import com.example.demo.Kafka.Producer;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class MessageController {


    private Producer producer;



    public MessageController(Producer producer) {
        this.producer = producer;
    }



//http:localhost:8080/api/kafka/publish?message=Hello World
    @GetMapping("/publish")
    public ResponseEntity<String> publish(@RequestParam("message") String message)
    {
        producer.sendMessage(message);
        return ResponseEntity.ok("message sent to topic successfully");
    }



}
