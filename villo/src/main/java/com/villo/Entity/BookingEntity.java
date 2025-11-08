package com.villo.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Table(name = "bookings_table")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class BookingEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Integer customer_id;
    private Long driver_id;
    private Integer vehicle_id;

    private String pickup_address;
    private Double pickup_lat;
    private Double pickup_lng;

    private String drop_address;
    private Double drop_lat;
    private Double drop_lng;

    @Enumerated(EnumType.STRING)
    private Status status = Status.REQUESTED;

    private Double fare_estimate;
    private Double fare_final;
    private LocalDateTime startTime;

    private LocalDateTime endTime;

    @Enumerated(EnumType.STRING)
    private PaymentMethod payment_method = PaymentMethod.CASH;

    public enum Status {
        REQUESTED, SEARCHING, CONFIRMED, ARRIVING, IN_PROGRESS, COMPLETED, CANCELLED, NO_DRIVER
    }

    public enum PaymentMethod {
        CASH, CARD, WALLET
    }
}

