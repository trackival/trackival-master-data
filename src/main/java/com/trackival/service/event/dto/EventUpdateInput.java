package com.trackival.service.event.dto;

import com.trackival.service.address.AddressInput;
import com.trackival.service.contact.ContactInput;
import com.trackival.service.event.entity.EventVisibility;
import lombok.*;

import java.time.LocalDateTime;

@Data
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PROTECTED)
public class EventUpdateInput {
    private String title;
    private String description;
    private LocalDateTime start;
    private LocalDateTime end;
    private int minimumAge;
    private AddressInput address;
    private ContactInput contact;
    private EventVisibility visibility;
}
