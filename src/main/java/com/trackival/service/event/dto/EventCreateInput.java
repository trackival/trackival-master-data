package com.trackival.service.event.dto;

import com.trackival.service.address.AddressInput;
import com.trackival.service.contact.ContactInput;
import com.trackival.service.event.entity.EventVisibility;
import lombok.*;

import java.time.LocalDateTime;
import java.util.UUID;

@Data
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PROTECTED)
public class EventCreateInput {
    private String title;
    private String description;
    private LocalDateTime start;
    private LocalDateTime end;
    private int minimumAge;
    private AddressInput address;
    private ContactInput contact;
    private UUID organizerId;
    private EventVisibility visibility;
}
