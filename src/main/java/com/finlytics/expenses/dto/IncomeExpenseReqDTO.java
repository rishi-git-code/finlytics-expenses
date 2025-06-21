package com.finlytics.expenses.dto;

import lombok.Data;

@Data
public class IncomeExpenseReqDTO {

    private String type;
    private String category;
    private double amount;
    private  String description;
}
