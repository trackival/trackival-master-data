package com.trackival.mdm.event.entity;

import com.trackival.mdm.address.Address;
import com.trackival.mdm.common.BaseEntity;
import com.trackival.mdm.contact.Contact;
import com.trackival.mdm.user.entity.User;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

@Entity
@Table(name = "trackival_event")

@Getter
@Setter
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PROTECTED)
@ToString(callSuper = true, onlyExplicitlyIncluded = true)
@EqualsAndHashCode(callSuper = true, onlyExplicitlyIncluded = true)
public class Event extends BaseEntity {
    @NotNull
    @ToString.Include
    @Column(nullable = false)
    private String title;

    @NotNull
    @ToString.Include
    @Column(nullable = false)
    private String description;

    @NotNull
    @Builder.Default
    @ToString.Include
    @Column(name = "event_start", nullable = false)
    private LocalDateTime start = LocalDateTime.now();

    @NotNull
    @Builder.Default
    @ToString.Include
    @Column(name = "event_end", nullable = false)
    private LocalDateTime end = LocalDateTime.now().plusHours(5);

    @NotNull
    @Builder.Default
    @ToString.Include
    @Column(name = "minimum_age", nullable = false, length = 3)
    private int minimumAge = 16;

    @NotNull
    @OneToOne(fetch = FetchType.EAGER, cascade = {CascadeType.ALL})
    @JoinColumn(name = "address_id", referencedColumnName = "id")
    private Address address;

    @OneToOne(fetch = FetchType.EAGER, cascade = {CascadeType.ALL})
    @JoinColumn(name = "contact_id", referencedColumnName = "id")
    private Contact contact;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "organizer_id", referencedColumnName = "id", nullable = false)
    private User organizer;

    @Builder.Default
    @ToString.Include
    @Enumerated(value = EnumType.STRING)
    @Column(name = "event_visibility", nullable = false)
    private EventVisibility visibility = EventVisibility.PUBLIC;
}
