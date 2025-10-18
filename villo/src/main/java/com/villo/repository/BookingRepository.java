package com.villo.repository;

import com.villlo.villo.jooq.enums.BookingsTableStatus;
import com.villlo.villo.jooq.enums.VehiclesTableStatus;
import com.villlo.villo.jooq.enums.VehiclesTableVehicleType;
import com.villo.model.BookingRequestDto;
import com.villo.model.UserRequestDto;
import lombok.RequiredArgsConstructor;
import org.jooq.DSLContext;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;

import static com.villlo.villo.jooq.Tables.BOOKINGS_TABLE;

@Repository
@RequiredArgsConstructor
public class BookingRepository {
    private final DSLContext dslContext;
    public void createBooking(BookingRequestDto bookingRequestDto) {

        BookingsTableStatus jooqStatus =
                BookingsTableStatus.valueOf(bookingRequestDto.getStatus().toLowerCase());

//        dslContext.insertInto(BOOKINGS_TABLE)
//                  //  .set(BOOKINGS_TABLE.CUSTOMER_ID, bookingRequestDto.getCustomerId())
//                    //.set(BOOKINGS_TABLE.DRIVER_ID, bookingRequestDto.getDriverId())
//                    .set(BOOKINGS_TABLE.VEHICLE_ID, bookingRequestDto.getVehicleId())
//                    .set(BOOKINGS_TABLE.PICKUP_LOCATION_ID, bookingRequestDto.getPickupLocationId())
//                    .set(BOOKINGS_TABLE.DROP_LOCATION_ID, bookingRequestDto.getDropLocationId())
//                    .set(BOOKINGS_TABLE.STATUS, jooqStatus)
//                    .set(BOOKINGS_TABLE.FARE, bookingRequestDto.getFare())
//                    .set(BOOKINGS_TABLE.CREATED_AT, LocalDateTime.now())
//                    .execute();
        }
}
