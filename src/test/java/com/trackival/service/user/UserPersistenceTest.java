package com.trackival.service.user;

import com.trackival.service.address.entity.Address;
import com.trackival.service.user.entity.Gender;
import com.trackival.service.user.entity.User;
import com.trackival.service.user.entity.UserRepository;
import com.trackival.service.user.entity.UserSettings;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
@ActiveProfiles("test")
class UserPersistenceTest {
    @Autowired
    private UserRepository repository;

    @Test
    void testPersistence() {
        final User user = User.builder()
                .firstName("Gökhan")
                .lastName("Topcu")
                .mail("goekhanm.topcu@gmail.com")
                .password("PASSWORD")
                .username("gtopcu")
                .dateOfBirth(LocalDate.of(2002, Month.MARCH, 12))
                .address(Address.builder().country("Germany").houseNumber("4").street("MönchStr.").zipCode("53881").town("Euskirchen").build())
                .gender(Gender.MALE)
                .settings(UserSettings.builder().build())
                .interests(new ArrayList<>())
                .build();
        final User result = this.repository.save(user);
        assertEquals(user.getId(), result.getId());
        System.out.println("USER: " + user);
        System.out.println("RESULT: " + result);
    }
}
