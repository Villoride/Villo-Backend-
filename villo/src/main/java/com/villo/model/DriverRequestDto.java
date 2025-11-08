package com.villo.model;



import com.villo.villoEnum.Role;
import lombok.Data;

@Data
public class DriverRequestDto {

    // User (from UserRequestDto)
    private String firstName;
    private String lastName;
    private String phoneNumber;
    private String email;
    private String password;
    private String address;


    private Role role = Role.DRIVER;

    // Vehicle Details
    private String vehicleNumber;
    private String vehicleType;
    private Integer capacity;
}

