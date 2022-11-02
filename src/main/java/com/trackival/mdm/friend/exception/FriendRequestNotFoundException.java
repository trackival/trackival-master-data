package com.trackival.mdm.friend.exception;

import com.trackival.mdm.common.exception.TrackivalMasterDataException;
import lombok.Getter;

import java.util.UUID;

@Getter
public class FriendRequestNotFoundException extends TrackivalMasterDataException {
    private final UUID id;

    public FriendRequestNotFoundException(UUID id) {
        super(String.format("FriendRequest with id='%s' not found", id));
        this.id = id;
    }
}
