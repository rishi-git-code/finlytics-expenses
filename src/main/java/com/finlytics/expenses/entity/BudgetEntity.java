package com.finlytics.expenses.entity;

import lombok.Data;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;
import java.util.List;

@Data
@Document(collection = "budget")
public class BudgetEntity {

    @Id
    private String budgetId;
    private String userId;
    private String name;
    private String duration;
    private double amount;
    private String currency;
    private List<CategoryEntity> categoryEntities;

    @CreatedDate
    private LocalDateTime createdAt;

    @LastModifiedDate
    private LocalDateTime updatedAt;
}
