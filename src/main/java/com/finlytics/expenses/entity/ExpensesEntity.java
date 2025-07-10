package com.finlytics.expenses.entity;

import lombok.Data;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;
import java.util.List;

@Data
@Document(collection = "expense")
public class ExpensesEntity {

    @Id
    private String expenseId;

    private String userId;
    private String type;
    private double amount;
    private  String description;
    private List<CategoryEntity> categoryEntities;

    @CreatedDate
    private LocalDateTime createdAt;

    @LastModifiedDate
    private LocalDateTime updatedAt;
}
