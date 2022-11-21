package com.trackival.mdm.user.dto;

import com.trackival.mdm.address.AddressInput;
import com.trackival.mdm.user.entity.Gender;
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
    private Gender gender;
}
