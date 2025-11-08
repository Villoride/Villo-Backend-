package com.villo.service;


import com.villo.model.DriverRequestDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Log4j2

public class DriverService1 {
    private  final DriverService driverRepository;
    public  void deriverDetailSave(DriverRequestDto driver) {
        driverRepository.registerDriver(driver);
    }
}
