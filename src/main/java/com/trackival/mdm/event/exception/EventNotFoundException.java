package com.trackival.mdm.event.exception;

import lombok.Getter;

import java.util.UUID;

@Getter
public class EventNotFoundException extends RuntimeException {
    private final UUID id;

    public EventNotFoundException(UUID id) {
        super(String.format("Event with id='%s' not found", id));
        this.id = id;
    }
}
