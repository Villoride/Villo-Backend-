package com.villo.service;

import com.villo.model.UserRequestDto;
import com.villo.repository.UsersRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Log4j2

public class UsersService {
    private final UsersRepository usersRepository;

    public void createUser(UserRequestDto userRequestDto) {
        usersRepository.createUser(userRequestDto);
    }
}
