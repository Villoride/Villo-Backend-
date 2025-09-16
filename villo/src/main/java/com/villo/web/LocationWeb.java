package com.villo.web;

import com.villo.model.LocationRequestDto;
import com.villo.service.LocationService;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/locations")
@RequiredArgsConstructor
public class LocationWeb {

    private final LocationService service;

    @PostMapping("/create")
    public ResponseEntity<String> createLocation(@RequestBody LocationRequestDto requestDto) {
        service.createLocation(requestDto);
        return ResponseEntity.ok("Location created successfully");
    }
}
