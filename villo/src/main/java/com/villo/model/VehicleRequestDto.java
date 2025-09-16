package com.villo.model;

import jakarta.validation.constraints.NotNull;
import lombok.Data;



@Data
public class VehicleRequestDto {
    // Optional if DB auto-generates

    @NotNull
    private Long userId;      // Link to user

    @NotNull
    private String vehicleNumber;

    @NotNull
    private String type;        // car, bike, auto

    private Integer capacity;

    private String status;      // active/inactive
}
