package com.trackival.mdm.contact;

import com.trackival.mdm.common.BaseEntity;
import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "contact")

@Getter
@Setter
@Builder
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PROTECTED)
public class Contact extends BaseEntity {
    private String phone;
    private String mail;
    private String twitter;
    private String instagram;
    private String facebook;
    private String website;
}
