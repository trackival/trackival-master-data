package com.trackival.service.event.dto;

import com.trackival.service.event.entity.Event;
import lombok.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Data
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PROTECTED)
public class EventPage {
    public static EventPage empty() {
        return new EventPage(0, 0, Collections.emptyList());
    }

    private int page;
    private int totalPages;
    @Builder.Default
    private List<Event> events = new ArrayList<>();
}
