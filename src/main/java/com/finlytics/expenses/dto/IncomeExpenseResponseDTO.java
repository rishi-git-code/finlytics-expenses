package com.finlytics.expenses.dto;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class IncomeExpenseResponseDTO {

    private String id;
    private String type;
    private String category;
    private double amount;
    private String description;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}
