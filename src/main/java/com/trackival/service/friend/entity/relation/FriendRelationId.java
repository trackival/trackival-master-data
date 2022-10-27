package com.trackival.service.friend.entity.relation;

import lombok.*;
import org.hibernate.annotations.Type;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;
import java.util.UUID;

@Data
@Builder
@ToString
@Embeddable
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PROTECTED)
public class FriendRelationId implements Serializable {
    @Type(type = "uuid-char")
    @Column(name = "first_id")
    private UUID id1;

    @Type(type = "uuid-char")
    @Column(name = "second_id")
    private UUID id2;
}
