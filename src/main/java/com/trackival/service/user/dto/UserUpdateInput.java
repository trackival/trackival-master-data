package com.trackival.service.user.dto;

import com.trackival.service.address.AddressInput;
import com.trackival.service.contact.ContactInput;
import com.trackival.service.user.entity.Gender;
import lombok.*;

import java.time.LocalDate;

@Data
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PROTECTED)
public class UserUpdateInput {
    private String firstName;
    private String lastName;
    private String mail;
    private String password;
    private String username;
    private LocalDate dateOfBirth;
    private String biography;
    private AddressInput address;
    private ContactInput contact;
    private Gender gender;
}
