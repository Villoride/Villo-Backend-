package com.villo.service;

import com.villo.model.UserRequestDto;
import com.villo.model.VehicleRequestDto;
import com.villo.repository.UsersRepository;
import com.villo.repository.VehiclesRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Log4j2
public class VehiclesService {
    private final VehiclesRepository vehiclesRepository;

    public void createVehicle(VehicleRequestDto vehicleRequestDto) {
        vehiclesRepository.createVehicles(vehicleRequestDto);
    }
}
