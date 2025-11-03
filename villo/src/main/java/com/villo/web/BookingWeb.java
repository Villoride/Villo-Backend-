package com.villo.web;

import com.villo.Entity.BookingEntity;
import com.villo.model.BookingRequestDto;
import com.villo.service.BookingService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/bookings")
@RequiredArgsConstructor
public class BookingWeb {

    private final BookingService bookingService;

    @PostMapping("/create")
    public ResponseEntity<String> createBooking(@RequestBody BookingEntity booking) {
        bookingService.saveBooking(booking);
        return ResponseEntity.ok("Booking created successfully!");
    }
    @PutMapping("/update-status/{id}")
    public ResponseEntity<String> updateStatus(
            @PathVariable Long id,
            @RequestParam String status,
            @RequestParam(required = false) Long driverId) {
        bookingService.updateBookingStatus(id, status, driverId);
        return ResponseEntity.ok("Booking updated!");
    }
}

