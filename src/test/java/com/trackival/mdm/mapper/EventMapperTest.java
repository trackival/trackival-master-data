package com.trackival.mdm.mapper;

import com.trackival.mdm.address.AddressInput;
import com.trackival.mdm.address.Address;
import com.trackival.mdm.contact.Contact;
import com.trackival.mdm.event.control.EventMapper;
import com.trackival.mdm.event.dto.EventCreateInput;
import com.trackival.mdm.event.dto.EventUpdateInput;
import com.trackival.mdm.event.entity.Event;
import com.trackival.mdm.event.entity.EventVisibility;
import com.trackival.mdm.user.entity.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import java.time.LocalDateTime;
import java.time.Month;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@ActiveProfiles("test")
class EventMapperTest {
    @Autowired
    private EventMapper mapper;

    @Test
    void testEventCreationMapper() {
        final EventCreateInput create = EventCreateInput.builder()
                .title("Titel des Events")
                .description("Beschreibung des Events")
                .minimumAge(18)
                .start(LocalDateTime.of(2022, Month.OCTOBER, 28, 23, 0))
                .end(LocalDateTime.of(2022, Month.OCTOBER, 29, 6, 0))
                .visibility(EventVisibility.PUBLIC)
                .address(AddressInput.builder().street("Auenweg").houseNumber("173").zipCode("51063").town("Köln").country("Germany").build())
                .build();

        final User user = User.builder().build();

        final Event event = this.mapper.toEntity(create, user);

        assertEquals(create.getTitle(), event.getTitle());
        assertEquals(create.getDescription(), event.getDescription());
        assertEquals(create.getMinimumAge(), event.getMinimumAge());
        assertEquals(create.getStart(), event.getStart());
        assertEquals(create.getEnd(), event.getEnd());
        assertEquals(create.getVisibility(), event.getVisibility());

        assertEquals(create.getAddress().getStreet(), event.getAddress().getStreet());
        assertEquals(create.getAddress().getCountry(), event.getAddress().getCountry());
        assertEquals(create.getAddress().getTown(), event.getAddress().getTown());
        assertEquals(create.getAddress().getZipCode(), event.getAddress().getZipCode());
        assertEquals(create.getAddress().getHouseNumber(), event.getAddress().getHouseNumber());
    }

    @Test
    void testEventUpdateMapper() {
        final EventUpdateInput update = EventUpdateInput.builder()
                .title("Rave in London")
                .description("Hier werden sich gottlose Teile geschmissen")
                .minimumAge(18)
                .visibility(EventVisibility.PROTECTED)
                .build();

        final Event event = Event.builder()
                .title("Karnevalsparty in Kölle")
                .description("Es gibt Freibier")
                .visibility(EventVisibility.PUBLIC)
                .minimumAge(16)
                .start(LocalDateTime.now())
                .end(LocalDateTime.now())
                .address(Address.builder().build())
                .organizer(User.builder().build())
                .contact(Contact.builder().build())
                .build();
        this.mapper.update(update, event);

        assertEquals(update.getTitle(), event.getTitle());
        assertEquals(update.getDescription(), event.getDescription());
        assertEquals(update.getMinimumAge(), event.getMinimumAge());
        assertEquals(update.getVisibility(), event.getVisibility());
        assertNotNull(event.getStart());
        assertNotNull(event.getEnd());
        assertNotNull(event.getAddress());
        assertNotNull(event.getOrganizer());
        assertNotNull(event.getContact());
    }
}
