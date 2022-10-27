package com.trackival.service.user.entity;

import com.trackival.service.common.BaseEntity;
import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "user_settings")

@Getter
@Setter
@Builder
@ToString
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PROTECTED)
@EqualsAndHashCode(callSuper = true, onlyExplicitlyIncluded = true)
public class UserSettings extends BaseEntity {
    @Builder.Default
    @Column(name = "show_gender", nullable = false)
    private boolean showGender = true;

    @Builder.Default
    @Column(name = "show_interests", nullable = false)
    private boolean showInterests = true;

    @Builder.Default
    @Column(name = "show_date_of_birth", nullable = false)
    private boolean showDateOfBirth = true;
}
