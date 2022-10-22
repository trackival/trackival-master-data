package com.trackival.service.friend.entity.relation;

import com.trackival.service.user.entity.User;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "friend_relation")

@Getter
@Setter
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PROTECTED)
@ToString(onlyExplicitlyIncluded = true)
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class FriendRelation {
    @EmbeddedId
    private FriendRelationId id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(
            name = "first_id",
            referencedColumnName = "id",
            nullable = false,
            insertable = false,
            updatable = false,
            foreignKey = @ForeignKey(name = "fk_friend1_id")
    )
    private User friend1;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(
            name = "second_id",
            referencedColumnName = "id",
            nullable = false,
            insertable = false,
            updatable = false,
            foreignKey = @ForeignKey(name = "fk_friend2_id")
    )
    private User friend2;

    @Builder.Default
    @Column(nullable = false, updatable = false)
    private LocalDateTime timestamp = LocalDateTime.now();
}
