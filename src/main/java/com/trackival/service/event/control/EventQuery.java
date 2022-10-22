package com.trackival.service.event.control;

import com.trackival.service.event.dto.EventPage;
import com.trackival.service.event.entity.Event;
import com.trackival.service.event.entity.EventRepository;
import graphql.kickstart.tools.GraphQLQueryResolver;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class EventQuery implements GraphQLQueryResolver {
    private final EventRepository eventRepository;

    public EventPage fetchEvents(int page, int size) {
        final Page<Event> result = this.eventRepository.findAll(PageRequest.of(page, size));
        final int current = result.getNumber();
        final int totalPages = result.getTotalPages();
        return EventPage.builder().totalPages(totalPages).page(current).events(result.getContent()).build();
    }
}
