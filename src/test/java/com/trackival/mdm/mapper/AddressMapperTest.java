package com.trackival.mdm.mapper;

import com.trackival.mdm.address.Address;
import com.trackival.mdm.address.AddressInput;
import com.trackival.mdm.address.AddressMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
@ActiveProfiles("test")
class AddressMapperTest {
    @Autowired
    private AddressMapper mapper;

    @Test
    void testAddressMapper() {
        final AddressInput input = AddressInput.builder()
                .street("MönchStr.")
                .houseNumber("4")
                .zipCode("53881")
                .town("Euskirchen")
                .country("Germany")
                .build();
        final Address address = this.mapper.toEntity(input);

        assertEquals(input.getStreet(), address.getStreet());
        assertEquals(input.getHouseNumber(), address.getHouseNumber());
        assertEquals(input.getZipCode(), address.getZipCode());
        assertEquals(input.getTown(), address.getTown());
        assertEquals(input.getCountry(), address.getCountry());
        assertEquals(0.0, address.getLatitude());
        assertEquals(0.0, address.getLongitude());
    }

    @Test
    void testAddressMapperWithCoordinates() {
        final AddressInput input = AddressInput.builder()
                .street("MönchStr.")
                .houseNumber("4")
                .zipCode("53881")
                .town("Euskirchen")
                .country("Germany")
                .build();
        final double longitude = 50.6249003123496;
        final double latitude = 6.8500872847302325;
        final Address address = this.mapper.toEntity(input, longitude, latitude);

        assertEquals(input.getStreet(), address.getStreet());
        assertEquals(input.getHouseNumber(), address.getHouseNumber());
        assertEquals(input.getZipCode(), address.getZipCode());
        assertEquals(input.getTown(), address.getTown());
        assertEquals(input.getCountry(), address.getCountry());
        assertEquals(longitude, address.getLongitude());
        assertEquals(latitude, address.getLatitude());
    }
}
