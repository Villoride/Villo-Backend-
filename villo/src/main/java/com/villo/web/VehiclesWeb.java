package com.villo.web;

import com.villo.model.VehicleRequestDto;
import com.villo.service.VehiclesService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/villo/vehicles")
public class VehiclesWeb {

    private final VehiclesService vehiclesService;

    @PostMapping("/create")
    public ResponseEntity<?> createVehicle(@RequestBody VehicleRequestDto vehicleRequestDto) {
        vehiclesService.createVehicle(vehicleRequestDto);
        return ResponseEntity.ok("Vehicle created successfully");
    }
}