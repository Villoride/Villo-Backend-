package com.villo.service;

import com.villo.model.LocationRequestDto;
import com.villo.repository.LocationRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Log4j2
public class LocationService {
    private final LocationRepository locationRepository;
    public void createLocation(LocationRequestDto requestDto) {
        locationRepository.createLocation(requestDto);
    }
}
