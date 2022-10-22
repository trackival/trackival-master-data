package com.trackival.service.common;

import lombok.*;
import lombok.experimental.SuperBuilder;
import org.hibernate.annotations.Type;
import org.jetbrains.annotations.NotNull;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import java.util.UUID;

@Getter
@Setter
@ToString
@SuperBuilder
@MappedSuperclass
@EqualsAndHashCode
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public abstract class BaseEntity {
    @Id
    @NotNull
    @Builder.Default
    @Type(type = "uuid-char")
    @ToString.Include(rank = -1)
    @Column(updatable = false, nullable = false)
    private UUID id = UUID.randomUUID();
}
