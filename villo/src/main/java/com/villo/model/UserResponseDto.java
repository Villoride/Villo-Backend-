package com.villo.model;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class UserResponseDto {
    private Long userId;
    private String firstName;
    private String lastName;
    private String phoneNumber;
    private String email;
    private String role;
    private String address;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}

