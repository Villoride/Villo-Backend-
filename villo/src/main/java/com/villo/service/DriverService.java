package com.villo.service;

import com.villo.Entity.UserEntity;
import com.villo.Entity.VehicleEntity;
import com.villo.config.SecurityConfig;
import com.villo.model.DriverRequestDto;
import com.villo.repository.UserRepository;
import com.villo.repository.VehicleRepository;
import com.villo.villoEnum.Role;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;

@Repository
@RequiredArgsConstructor
public class DriverService {
 private final SecurityConfig securityConfig;
 private final UserRepository userRepository;
 private final VehicleRepository vehicleRepository;
    private final PasswordEncoder passwordEncoder;
    public void registerDriver(DriverRequestDto dto) {
        // Save user
        UserEntity user = new UserEntity();
        user.setFirstName(dto.getFirstName());
        user.setLastName(dto.getLastName());
        user.setPhoneNumber(dto.getPhoneNumber());
        user.setEmail(dto.getEmail());
        user.setPassword(passwordEncoder.encode(dto.getPassword()));user.setAddress(dto.getAddress());
        user.setRole(Role.DRIVER);

        UserEntity savedUser = userRepository.save(user);

        // Save vehicle
        VehicleEntity vehicle = new VehicleEntity();
        vehicle.setUserId(savedUser.getUserId());
        vehicle.setVehicleNumber(dto.getVehicleNumber());
        vehicle.setVehicleType(dto.getVehicleType());
        vehicle.setCapacity(dto.getCapacity());
        vehicle.setStatus("ACTIVE");
        vehicle.setCreatedAt(LocalDateTime.now());

        vehicleRepository.save(vehicle);
    }

}
