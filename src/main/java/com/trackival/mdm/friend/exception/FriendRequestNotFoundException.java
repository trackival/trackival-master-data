package com.trackival.mdm.friend.exception;

import lombok.Getter;

import java.util.UUID;

@Getter
public class FriendRequestNotFoundException extends RuntimeException {
    private final UUID id;

    public FriendRequestNotFoundException(UUID id) {
        super(String.format("FriendRequest with id='%s' not found", id));
        this.id = id;
    }
}
