package com.villo.web;

import com.villo.model.UserRequestDto;
import com.villo.service.UsersService;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/villo/users")
public class UsersWeb {

    private final UsersService usersService;

    @PostMapping("/create")
    public ResponseEntity<?> createUser(@RequestBody UserRequestDto userRequestDto,
                                        HttpServletRequest request) {
        usersService.createUser(userRequestDto);
        return ResponseEntity.ok("User created successfully");
    }
    @PostMapping("/get")
    public ResponseEntity<?> getUser(@RequestBody UserRequestDto userRequestDto,
                                        HttpServletRequest request) {
        usersService.createUser(userRequestDto);
        return ResponseEntity.ok("User created successfully");
    }
}
