package com.villo.model;

import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.math.BigDecimal;

@Data
public class LocationRequestDto {
    @NotNull
    private Long userId;

    @NotNull
    private String address;

    private BigDecimal latitude;
    private BigDecimal longitude;
}
