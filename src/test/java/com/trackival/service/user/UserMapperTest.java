package com.trackival.service.user;

import com.trackival.service.address.dto.AddressInput;
import com.trackival.service.user.control.UserMapper;
import com.trackival.service.user.dto.UserRegistrationInput;
import com.trackival.service.user.entity.Gender;
import com.trackival.service.user.entity.User;
import com.trackival.service.user.dto.UserCreateInput;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import java.time.LocalDate;
import java.time.Month;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
@ActiveProfiles("test")
class UserMapperTest {

    @Autowired
    private UserMapper mapper;

    @Test
    void testUserRegistrationInputMapping() {
        final UserRegistrationInput registration = UserRegistrationInput.builder()
                .firstName("Gökhan")
                .lastName("Topcu")
                .dateOfBirth(LocalDate.of(2022, Month.MARCH, 12))
                .username("goekhantopcu")
                .password("pwd")
                .mail("goekhan.topcu@trackival.com")
                .address(AddressInput.builder().street("MönchStr.").houseNumber("4").zipCode("53881").country("Germany").town("Euskirchen").build())
                .gender(Gender.MALE)
                .build();
        final User user = assertDoesNotThrow(() -> this.mapper.toEntity(registration));
        assertEquals(user.getFirstName(), registration.getFirstName());
        assertEquals(user.getLastName(), registration.getLastName());
        assertEquals(user.getDateOfBirth(), registration.getDateOfBirth());
        assertEquals(user.getUsername(), registration.getUsername());
        assertEquals(user.getPassword(), registration.getPassword());
        assertEquals(user.getMail(), registration.getMail());
        assertEquals(user.getAddress().getStreet(), registration.getAddress().getStreet());
        assertEquals(user.getGender(), registration.getGender());
    }

    /*
    @Test
    void testUserMapper() {
        final UserCreateInput input = UserCreateInput.builder()
                .firstName("Gökhan")
                .lastName("Topcu")
                .dateOfBirth(LocalDate.of(2002, Month.MARCH, 12))
                .gender(Gender.MALE)
                .mail("goekhan.topcu@telekom.de")
                .password("TestPassword")
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
        final User user = this.mapper.toEntity(input);
        assertEquals(input.getFirstName(), user.getFirstName());
        assertEquals(input.getLastName(), user.getLastName());
        System.out.println("User: " + user);
    }
     */
}
