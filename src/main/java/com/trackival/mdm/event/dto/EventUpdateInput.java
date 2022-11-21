package com.trackival.mdm.event.dto;

import com.trackival.mdm.address.AddressInput;
import com.trackival.mdm.event.entity.EventVisibility;
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
    private EventVisibility visibility;
}
