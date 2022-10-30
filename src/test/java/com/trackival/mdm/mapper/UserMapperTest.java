package com.trackival.mdm.mapper;

import com.trackival.mdm.address.AddressInput;
import com.trackival.mdm.address.Address;
import com.trackival.mdm.user.control.UserMapper;
import com.trackival.mdm.user.dto.UserRegistrationInput;
import com.trackival.mdm.user.dto.UserUpdateInput;
import com.trackival.mdm.user.entity.Gender;
import com.trackival.mdm.user.entity.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import java.time.LocalDate;
import java.time.Month;

import static org.junit.jupiter.api.Assertions.*;

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

    @Test
    void testUserUpdateInputMapping() {
        final UserUpdateInput update = UserUpdateInput.builder()
                .gender(Gender.MALE)
                .firstName("Gökhan")
                .lastName("Topcu")
                .build();
        final User user = User.builder()
                .gender(Gender.FEMALE)
                .firstName("Mehmet")
                .lastName("Autoteile")
                .mail("mehmet.autoteile@trackival.com")
                .password("pwd")
                .username("mehmet.autoteile")
                .dateOfBirth(LocalDate.now())
                .biography("Das ist die Biografie")
                .gender(Gender.FEMALE)
                .address(Address.builder().street("MönchStr.").houseNumber("4").zipCode("53881").country("Germany").town("Euskirchen").build())
                .build();
        final User updated = this.mapper.update(update, user);
        assertEquals(updated.getFirstName(), user.getFirstName());
        assertEquals(updated.getMail(), user.getMail());
        assertNotEquals(updated.getMail(), update.getMail());
    }
}
