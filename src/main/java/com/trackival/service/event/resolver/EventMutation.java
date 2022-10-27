package com.trackival.service.event.resolver;

import com.trackival.service.event.control.EventControl;
import com.trackival.service.event.dto.EventCreateInput;
import com.trackival.service.event.dto.EventUpdateInput;
import com.trackival.service.event.entity.Event;
import graphql.kickstart.tools.GraphQLMutationResolver;
import org.jetbrains.annotations.NotNull;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class EventMutation implements GraphQLMutationResolver {
    private EventControl control;

    public Event createEvent(@NotNull EventCreateInput create) {
        return this.control.createEvent(create);
    }

    public Event updateEvent(@NotNull UUID id, @NotNull EventUpdateInput update) {
        return this.control.updateEvent(id, update);
    }
}
