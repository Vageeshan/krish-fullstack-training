package com.innovation.kafkabasic.controller;

import com.innovation.kafkabasic.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.*;

/**
 * @Author G.Vageeshan
 * @Version 1.0
 * @since 2022-06-26 12:14 AM Sunday
 **/
@RestController("/api/v1")
public class KafkaController {

    @Autowired
    private KafkaTemplate<String, Object> kafkaTemplate;

    private final String TOPIC = "shivan";

    @GetMapping("/kafka/{name}")
    public ResponseEntity<?> publishMessage(@PathVariable String name) {
        System.out.println(name);
        kafkaTemplate.send(TOPIC, name);
        return ResponseEntity.ok("Message Sent");
    }

    @PostMapping("/kafka")
    public ResponseEntity<?> publishMessage(@RequestBody User user) {
        kafkaTemplate.send(TOPIC, user);
        return ResponseEntity.ok(user);
    }
}
