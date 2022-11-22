package com.trackival.mdm.contact.entity;

import com.trackival.mdm.common.BaseEntity;
import com.trackival.mdm.event.entity.Event;
import com.trackival.mdm.user.entity.User;
import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "contact")

@Getter
@Setter
@Builder
@ToString(callSuper = true, onlyExplicitlyIncluded = true)
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PROTECTED)
public class Contact extends BaseEntity {
    @ToString.Include
    @Column(name = "contact_key")
    private String contactKey;

    @ToString.Include
    @Column(name = "contact_value")
    private String contactValue;

    @Builder.Default
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private User user = null;

    @Builder.Default
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "event_id", referencedColumnName = "id")
    private Event event = null;
}
