package com.finlytics.expenses.dto;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class BudgetResDTO {
    private String budgetId;
    private String userId;
    private String name;
    private double amount;
    private String currency;
    private String category;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}
