package com.gobasket.gobasket.dto;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.UUID;

@Data
@Builder
public class UserResponse {

    private UUID id;
    private String name;
    private String phone;
    private String email;
    private LocalDateTime createdAt;
}