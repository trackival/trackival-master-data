package com.trackival.service.event.resolver;

import com.trackival.service.event.control.EventControl;
import com.trackival.service.event.dto.EventPage;
import com.trackival.service.event.entity.Event;
import graphql.kickstart.tools.GraphQLQueryResolver;
import org.jetbrains.annotations.NotNull;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.UUID;

@Component
public class EventQuery implements GraphQLQueryResolver {
    private EventControl control;

    public Event findEvent(@NotNull UUID id) {
        return this.control.findEvent(id);
    }

    public EventPage fetchEvents(int page, int size) {
        return this.control.fetchEvents(page, size);
    }

    public List<Event> fetchEvents(int page, int size, double longitude, double latitude, int distance) {
        return this.control.fetchEvents(page, size, longitude, latitude, distance);
    }
}
