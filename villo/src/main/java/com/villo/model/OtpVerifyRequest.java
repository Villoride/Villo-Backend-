package com.villo.model;

import lombok.Data;

@Data
public class OtpVerifyRequest {
    private Long userId;
    private String otp;
}