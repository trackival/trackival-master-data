package com.trackival.service.user.dto;

import com.trackival.service.address.dto.AddressInput;
import com.trackival.service.user.entity.Gender;
import lombok.*;

import java.time.LocalDate;

@Data
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PROTECTED)
public class UserRegistrationInput {
    private String firstName;
    private String lastName;
    private String mail;
    private String password;
    private String username;
    private LocalDate dateOfBirth;
    private AddressInput address;
    private Gender gender;
}
