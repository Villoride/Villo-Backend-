package com.villo.repository;

import com.villlo.villo.jooq.enums.BookingsTableStatus;

import com.villlo.villo.jooq.enums.UsersTableRole;
import com.villo.model.UserRequestDto;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.jooq.DSLContext;
import org.jooq.Record;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;

import static com.villlo.villo.jooq.Tables.USERS_TABLE;




@Repository
@Log4j2
@RequiredArgsConstructor
public class UsersRepository {

    private final DSLContext dslContext;

    public void createUser(UserRequestDto userRequestDto) {

        UsersTableRole jooqRole = UsersTableRole.valueOf(userRequestDto.getRole().name());


        dslContext.insertInto(USERS_TABLE)
                .set(USERS_TABLE.FIRST_NAME, userRequestDto.getFirstName())
                .set(USERS_TABLE.LAST_NAME, userRequestDto.getLastName())
                .set(USERS_TABLE.PHONE_NUMBER, userRequestDto.getPhoneNumber())
                .set(USERS_TABLE.EMAIL, userRequestDto.getEmail())
                .set(USERS_TABLE.PASSWORD, userRequestDto.getPassword())
                .set(USERS_TABLE.ROLE, jooqRole) // ✅ store enum as string
                .set(USERS_TABLE.ADDRESS, userRequestDto.getAddress())
                .set(USERS_TABLE.CREATED_AT, LocalDateTime.now())
                .returning()
                .fetchOne();
    }
}
