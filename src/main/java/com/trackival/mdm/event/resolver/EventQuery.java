package com.trackival.mdm.event.resolver;

import com.trackival.mdm.event.control.EventControl;
import com.trackival.mdm.event.dto.EventPage;
import com.trackival.mdm.event.entity.Event;
import graphql.kickstart.tools.GraphQLQueryResolver;
import org.jetbrains.annotations.NotNull;
import org.springframework.stereotype.Component;

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

    public EventPage fetchEvents(int page, int size, double longitude, double latitude, int distance) {
        return this.control.fetchEvents(page, size, longitude, latitude, distance);
    }
}