package com.villo.model;

import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.math.BigDecimal;

@Data
public class BookingRequestDto {

        @NotNull
        private Long customerId;

        @NotNull
        private Long driverId;

        @NotNull
        private Long vehicleId;

        @NotNull
        private Long pickupLocationId;

        @NotNull
        private Long dropLocationId;

        @NotNull
        private String status; // ACTIVE, COMPLETED, CANCELLED

        @NotNull
        private BigDecimal fare; // 💰
    }