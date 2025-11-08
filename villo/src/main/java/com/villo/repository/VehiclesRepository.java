package com.villo.repository;


import com.villo.model.VehicleRequestDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.jooq.DSLContext;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

import static com.villlo.villo.jooq.Tables.VEHICLES_TABLE;

@Service
@RequiredArgsConstructor
@Log4j2
public class VehiclesRepository {
    private final DSLContext dslContext;

    public void createVehicles(VehicleRequestDto vehicleRequestDto) {

       /* // Map DTO VehicleType (CAR) -> jOOQ enum (car)
        VehiclesTableVehicleType jooqType =
                VehiclesTableVehicleType.valueOf(vehicleRequestDto.getType().toLowerCase());
*/
     /*   // Map DTO Status (ACTIVE) -> jOOQ enum (active)
        VehiclesTableStatus jooqStatus =
                VehiclesTableStatus.valueOf(vehicleRequestDto.getStatus().toLowerCase());

        dslContext.insertInto(VEHICLES_TABLE)
               // .set(VEHICLES_TABLE.USER_ID, vehicleRequestDto.getUserId())
                .set(VEHICLES_TABLE.VEHICLE_NUMBER, vehicleRequestDto.getVehicleNumber())
                .set(VEHICLES_TABLE.VEHICLE_TYPE, jooqType)   // ✅ correct enum
                .set(VEHICLES_TABLE.CAPACITY, vehicleRequestDto.getCapacity())
                .set(VEHICLES_TABLE.CREATED_AT, LocalDateTime.now())
                .set(VEHICLES_TABLE.STATUS, jooqStatus) // ✅ correct enum
                .execute();
    }*/
    }
}


