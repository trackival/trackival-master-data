package com.trackival.mdm.user.like.entity;

import com.trackival.mdm.event.control.EventControl;
import com.trackival.mdm.event.entity.Event;
import com.trackival.mdm.user.entity.User;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "user_event_like")

@Getter
@Setter
@Builder
@ToString(onlyExplicitlyIncluded = true)
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PROTECTED)
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Like {
    @EmbeddedId
    @EqualsAndHashCode.Include
    private LikeId id;

    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("eventId")
    private Event event;

    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("userId")
    private User user;

    @Builder.Default
    @Column(name = "liked_at")
    private LocalDateTime likedAt = LocalDateTime.now();
}
