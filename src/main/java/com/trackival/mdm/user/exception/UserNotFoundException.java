package com.trackival.mdm.user.exception;

import com.trackival.mdm.common.exception.TrackivalMasterDataException;
import lombok.Getter;

import java.util.UUID;

@Getter
public class UserNotFoundException extends TrackivalMasterDataException {
    private final UUID id;

    public UserNotFoundException(UUID id) {
        super(String.format("User with id='%s' not found", id));
        this.id = id;
    }
}
