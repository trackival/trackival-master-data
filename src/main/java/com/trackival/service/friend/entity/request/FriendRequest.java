package com.trackival.service.friend.entity.request;

import com.trackival.service.common.BaseEntity;
import com.trackival.service.user.entity.User;
import lombok.*;
import lombok.experimental.SuperBuilder;
import org.hibernate.annotations.CacheModeType;
import org.hibernate.annotations.NamedQueries;
import org.hibernate.annotations.NamedQuery;
import org.jetbrains.annotations.NotNull;

import javax.persistence.*;
import java.sql.Timestamp;
import java.time.Instant;
import java.time.LocalDateTime;

@Entity
@Table(name = "friend_request")

@Getter
@Setter
@SuperBuilder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PROTECTED)
@ToString(callSuper = true, onlyExplicitlyIncluded = true)
@EqualsAndHashCode(callSuper = true, onlyExplicitlyIncluded = true)
public class FriendRequest extends BaseEntity {
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "receiver_id", referencedColumnName = "id", foreignKey = @ForeignKey(name = "fk_receiver_id"))
    private User receiver;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "sender_id", referencedColumnName = "id", foreignKey = @ForeignKey(name = "fk_sender_id"))
    private User sender;

    @Builder.Default
    @Column(nullable = false, updatable = false)
    private LocalDateTime timestamp = LocalDateTime.now();
}
