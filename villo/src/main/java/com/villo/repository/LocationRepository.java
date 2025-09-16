package com.villo.repository;
import com.villo.model.LocationRequestDto;
import lombok.RequiredArgsConstructor;
import org.jooq.DSLContext;
import org.springframework.stereotype.Repository;

import static com.villlo.villo.jooq.tables.LocationsTable.LOCATIONS_TABLE;

@Repository
@RequiredArgsConstructor
public class LocationRepository {

    private final DSLContext dslContext;

    public void createLocation(LocationRequestDto requestDto) {
        dslContext.insertInto(LOCATIONS_TABLE)
                .set(LOCATIONS_TABLE.USER_ID, requestDto.getUserId())
                .set(LOCATIONS_TABLE.ADDRESS, requestDto.getAddress())
                .set(LOCATIONS_TABLE.LATITUDE, requestDto.getLatitude())
                .set(LOCATIONS_TABLE.LONGITUDE, requestDto.getLongitude())
                .execute();
    }
}
