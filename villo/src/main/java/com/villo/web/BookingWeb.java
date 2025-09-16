package com.villo.web;

import com.villo.model.BookingRequestDto;
import com.villo.service.BookingService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/bookings")
@RequiredArgsConstructor
public class BookingWeb {

    private final BookingService bookingService;

    @PostMapping("/create")
    public ResponseEntity<String> createBooking(@RequestBody BookingRequestDto bookingRequestDto) {
        bookingService.createBooking(bookingRequestDto);
        return ResponseEntity.ok("Booking created successfully!");
    }
}

