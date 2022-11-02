package com.trackival.mdm.event.exception;

import com.trackival.mdm.common.exception.TrackivalMasterDataException;
import lombok.Getter;

import java.util.UUID;

@Getter
public class EventNotFoundException extends TrackivalMasterDataException {
    private final UUID id;

    public EventNotFoundException(UUID id) {
        super(String.format("Event with id='%s' not found", id));
        this.id = id;
    }
}
