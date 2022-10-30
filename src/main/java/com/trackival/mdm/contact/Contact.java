package com.trackival.mdm.contact;

import com.trackival.mdm.common.BaseEntity;
import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "trackival_contact")

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

    public Contact merge(Contact contact) {
        this.phone = contact.getPhone();
        this.mail = contact.getMail();
        this.twitter = contact.getTwitter();
        this.instagram = contact.getInstagram();
        this.facebook = contact.getFacebook();
        this.website = contact.getWebsite();
        return this;
    }
}
