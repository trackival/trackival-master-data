package com.trackival.service.event.dto;

import com.trackival.service.event.entity.Event;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Data
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PROTECTED)
public class EventPage {
    private int page;
    private int totalPages;
    @Builder.Default
    private List<Event> events = new ArrayList<>();
}
