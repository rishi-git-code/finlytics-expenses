package com.finlytics.expenses.entity;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.Instant;

@Data
@Document(collection = "user_reference")
public class UserReference {

    @Id
    private String userId;
    private String username;
    private String email;
    private String status;
    private Instant updatedAt;
}