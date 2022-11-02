package com.trackival.mdm.user.exception;

import lombok.Getter;

import java.util.UUID;

@Getter
public class UserNotFoundException extends RuntimeException {
    private final UUID id;

    public UserNotFoundException(UUID id) {
        super(String.format("User with id='%s' not found", id));
        this.id = id;
    }
}
