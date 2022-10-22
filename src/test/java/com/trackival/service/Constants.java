package com.trackival.service;

import com.trackival.service.address.dto.AddressInput;
import com.trackival.service.user.entity.Gender;
import com.trackival.service.user.dto.UserCreateInput;

import java.time.LocalDate;
import java.time.Month;

public final class Constants {
    public static final UserCreateInput USER_CREATE_INPUT = UserCreateInput.builder()
            .firstName("Gökhan")
            .lastName("Topcu")
            .dateOfBirth(LocalDate.of(2002, Month.MARCH, 12))
            .gender(Gender.MALE)
            .mail("goekhan.topcu@telekom.de")
            .password("TestPassword")
            .username("hitler")
            .address(
                    AddressInput.builder()
                            .houseNumber("4")
                            .street("MönchStr.")
                            .country("Germany")
                            .town("Euskirchen")
                            .zipCode("53881")
                            .build()
            )
            .build();
}
