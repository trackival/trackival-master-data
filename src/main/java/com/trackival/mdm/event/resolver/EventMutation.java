package com.trackival.mdm.event.resolver;

import com.netflix.graphql.dgs.DgsComponent;
import com.netflix.graphql.dgs.DgsMutation;
import com.netflix.graphql.dgs.InputArgument;
import com.trackival.mdm.event.control.EventControl;
import com.trackival.mdm.event.dto.EventCreateInput;
import com.trackival.mdm.event.dto.EventUpdateInput;
import com.trackival.mdm.event.entity.Event;
import lombok.AllArgsConstructor;
import org.jetbrains.annotations.NotNull;

import java.util.UUID;

@DgsComponent
@AllArgsConstructor
public class EventMutation {
    private EventControl control;

    @DgsMutation
    public @NotNull Event createEvent(@InputArgument EventCreateInput create) {
        return this.control.createEvent(create);
    }

    @DgsMutation
    public @NotNull Event updateEvent(@InputArgument UUID id, @InputArgument EventUpdateInput update) {
        return this.control.updateEvent(id, update);
    }
}
