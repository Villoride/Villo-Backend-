package com.villo.model;



import com.villo.villoEnum.Role;
import lombok.Data;

@Data
public class UserRequestDto {

    private String userId;
    private String firstName;
    private String lastName;
    private String phoneNumber;
    private String email;
    private String password;
    private Role role;
    private String address;
}
