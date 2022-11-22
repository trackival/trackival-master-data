package com.trackival.mdm.contact.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AddContactInput {
    @NotNull
    private String key;

    @NotNull
    private String value;

    @Nullable
    private UUID userId;

    @Nullable
    private UUID eventId;

    public boolean isUser() {
        return this.eventId == null && this.userId != null;
    }

    public boolean isEvent() {
        return this.eventId != null && this.userId == null;
    }
}
