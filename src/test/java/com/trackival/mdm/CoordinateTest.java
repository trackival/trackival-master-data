package com.trackival.mdm;

import com.trackival.mdm.coordinate.CoordinateResult;
import com.trackival.mdm.coordinate.CoordinateService;
import com.trackival.mdm.address.Address;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
@ActiveProfiles("test")
class CoordinateTest {
    @Autowired
    private CoordinateService service;

    @Test
    void testCoordinate() {
        final Address address = Address.builder()
                .street("Landgrabenweg")
                .houseNumber("151")
                .zipCode("53227")
                .town("Bonn")
                .country("Germany")
                .build();
        final CoordinateResult coordinate = assertDoesNotThrow(() -> this.service.findCoordinate(address));
        assertNotNull(coordinate);
        System.out.println(" ");
        System.out.println("---------------------------------");
        System.out.println("Longitude: " + coordinate.getLongitude());
        System.out.println("Latitude: " + coordinate.getLatitude());
        System.out.println("---------------------------------");
        System.out.println(" ");
    }
}
