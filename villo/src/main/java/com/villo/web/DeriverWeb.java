package com.villo.web;

import com.villo.model.DriverRequestDto;
import com.villo.service.DriverService;
import com.villo.service.DriverService1;
import com.villo.villoEnum.Role;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/villo/deriver")
@RequiredArgsConstructor
public class DeriverWeb {
    private final DriverService driverService;
    @PostMapping("/register-driver")
    public ResponseEntity<String> registerDriver(@RequestBody DriverRequestDto driver) {
        driver.setRole(Role.DRIVER);
        driverService.registerDriver(driver);
        return ResponseEntity.ok("Driver Registered Successfully!");
    }

}
