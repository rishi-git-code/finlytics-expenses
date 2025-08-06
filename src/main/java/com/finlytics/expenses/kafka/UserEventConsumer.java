package com.finlytics.expenses.kafka;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.finlytics.expenses.dto.UserReqDTO;
import com.finlytics.expenses.services.UserReferenceService;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class UserEventConsumer {

    @Autowired
    private UserReferenceService userReferenceService;

    @Autowired
    private ObjectMapper objectMapper;

    @KafkaListener(topics = "user-events", groupId = "expenses-service")
    public void consume(ConsumerRecord<String, String> record) {
        try {
            UserReqDTO user = objectMapper.readValue(record.value(),UserReqDTO.class);
            System.out.println("Received user event: {}"+ user);
            switch (user.getEventType()) {
                case "Create":
                    userReferenceService.handleCreateUser(user);
                    break;
                case "Update":
                    userReferenceService.handleUpdateUser(user);
                    break;
                default:
                    System.out.println("Unknown Event :"+user.getEventType());
            }
        } catch (Exception e) {
            System.out.println("User processing event :"+e.getMessage());
            e.printStackTrace();
        }
    }
}
