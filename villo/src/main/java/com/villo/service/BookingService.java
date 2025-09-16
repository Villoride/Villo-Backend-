package com.villo.service;

import com.villo.model.BookingRequestDto;
import com.villo.model.UserRequestDto;
import com.villo.repository.BookingRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Log4j2
public class BookingService {

    private final BookingRepository bookingRepository;

    public void createBooking(BookingRequestDto bookingRequestDto) {
        bookingRepository.createBooking(bookingRequestDto);
    }
}
