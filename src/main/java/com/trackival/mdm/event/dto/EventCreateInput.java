package com.trackival.mdm.event.dto;

import com.trackival.mdm.address.AddressInput;
import com.trackival.mdm.event.entity.EventVisibility;
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
    private UUID organizerId;
    private EventVisibility visibility;
}
