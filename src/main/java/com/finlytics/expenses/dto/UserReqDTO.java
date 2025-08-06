package com.finlytics.expenses.dto;

import lombok.Data;

@Data
public class UserReqDTO {

    private String userId;
    private String username;
    private String email;
    private String status;
    private String eventType;
}
