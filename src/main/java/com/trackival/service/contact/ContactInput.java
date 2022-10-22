package com.trackival.service.contact;

import lombok.*;

@Data
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PROTECTED)
public class ContactInput {
    private String phone;
    private String mail;
    private String twitter;
    private String instagram;
    private String facebook;
    private String website;
}
