package com.trackival.mdm.event.resolver;

import com.netflix.graphql.dgs.*;
import com.trackival.mdm.address.Address;
import com.trackival.mdm.event.control.EventControl;
import com.trackival.mdm.event.dto.EventPage;
import com.trackival.mdm.event.entity.Event;
import com.trackival.mdm.user.entity.User;
import lombok.AllArgsConstructor;
import org.jetbrains.annotations.NotNull;

import java.util.UUID;

@DgsComponent
@AllArgsConstructor
public class EventQuery {
    private EventControl control;

    @DgsQuery
    public @NotNull Event findEvent(@InputArgument UUID id) {
        return this.control.findEvent(id);
    }

    @DgsQuery
    public @NotNull EventPage fetchEvents(@InputArgument Integer page, @InputArgument Integer size) {
        return this.control.fetchEvents(page, size);
    }

    @DgsQuery
    public @NotNull EventPage fetchEventsByPosition(
            @InputArgument Integer page,
            @InputArgument Integer size,
            @InputArgument Double longitude,
            @InputArgument Double latitude,
            @InputArgument Integer distance) {
        return this.control.fetchEventsByPosition(page, size, longitude, latitude, distance);
    }

    @DgsData(parentType = "Event")
    public @NotNull Address findAddress(DgsDataFetchingEnvironment environment) {
        final Event event = environment.getSource();
        return this.control.findAddress(event.getId());
    }

    @DgsData(parentType = "Event")
    public @NotNull User findUser(DgsDataFetchingEnvironment environment) {
        final Event event = environment.getSource();
        return this.control.findOrganizer(event.getId());
    }
}
