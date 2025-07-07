package com.finlytics.expenses.dto;

import lombok.Data;

@Data
public class BudgetReqDTO {
    private String name;
    private double amount;
    private String currency;
    private String category;
}
