package com.trackival.mdm.user.like.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Type;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;
import java.util.UUID;

@Data
@Builder
@Embeddable
@NoArgsConstructor
@AllArgsConstructor
public class LikeId implements Serializable {
    @Type(type = "uuid-char")
    @Column(name = "event_id")
    private UUID eventId;

    @Type(type = "uuid-char")
    @Column(name = "user_id")
    private UUID userId;
}
