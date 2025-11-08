package com.villo.service;

import com.villo.Entity.BookingEntity;
import com.villo.Entity.UserEntity;
import com.villo.repository.BookingRepository;
import com.villo.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
@Log4j2
public class BookingService {

    private final BookingRepository bookingRepository;
    private final UserRepository userRepository;

    public BookingEntity saveBooking(BookingEntity booking) {
        booking.setStatus(BookingEntity.Status.REQUESTED);
        return bookingRepository.save(booking);
    }

    public void updateBookingStatus(Long bookingId, String status, Long driverId) {

        // 1. Find booking
        BookingEntity booking = bookingRepository.findById(bookingId)
                .orElseThrow(() -> new RuntimeException("Booking not found with ID: " + bookingId));

        // 2. Validate and assign driver
        if (driverId != null) {
            UserEntity driver = userRepository.findById(driverId)
                    .orElseThrow(() -> new RuntimeException("Driver not found with ID: " + driverId));

            if (!"DRIVER".equalsIgnoreCase(driver.getRole().toString())) {
                throw new RuntimeException("User with ID " + driverId + " is not a driver.");
            }

            booking.setDriver_id(driverId);
        }

        // ✅ 3. Convert String → Enum for status
        try {
            BookingEntity.Status bookingStatus = BookingEntity.Status.valueOf(status.toUpperCase());
            booking.setStatus(bookingStatus);
        } catch (IllegalArgumentException e) {
            throw new RuntimeException("Invalid booking status: " + status);
        }

        // 4. Set timestamps based on status
        switch (booking.getStatus()) {
            case IN_PROGRESS:
                booking.setStartTime(LocalDateTime.now());
                break;

            case COMPLETED:
                booking.setEndTime(LocalDateTime.now());
                break;

            case CANCELLED:
            case CONFIRMED:
            case ARRIVING:
                // You can add logic here if needed
                break;
        }

        // 5. Save to database
        bookingRepository.save(booking);
        log.info("Booking {} updated to status {}", bookingId, status);
    }
}
