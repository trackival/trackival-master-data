package com.trackival.service.user.control;

import com.trackival.service.address.control.AddressMapper;
import com.trackival.service.address.dto.AddressInput;
import com.trackival.service.address.entity.Address;
import com.trackival.service.contact.Contact;
import com.trackival.service.contact.ContactInput;
import com.trackival.service.contact.ContactMapper;
import com.trackival.service.user.dto.UserRegistrationInput;
import com.trackival.service.user.entity.*;
import graphql.kickstart.tools.GraphQLMutationResolver;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import org.jetbrains.annotations.NotNull;

import java.time.LocalDate;
import java.util.Collections;
import java.util.List;
import java.util.UUID;

@Component
@RequiredArgsConstructor
public class UserMutation implements GraphQLMutationResolver {
    private final UserMapper userMapper;
    private final AddressMapper addressMapper;
    private final ContactMapper contactMapper;
    private final UserRepository userRepository;
    private final ExtendedUserRepository extendedUserRepository;

    public User registerUser(@NotNull UserRegistrationInput registration) {
        return this.userRepository.save(this.userMapper.toEntity(registration));
    }

    public User updateUser(UUID id, String firstName, String lastName, String mail, String password, LocalDate dateOfBirth, String biography, AddressInput address, ContactInput contact, Gender gender) {
        final Address mappedAddress = this.addressMapper.toEntity(address);
        final Contact mappedContact = this.contactMapper.toEntity(contact);
        return this.extendedUserRepository.updateUser(
                id,
                firstName,
                lastName,
                mail,
                password,
                dateOfBirth,
                biography,
                mappedAddress,
                mappedContact,
                gender
        );
    }

    public List<String> addInterest(UUID id, String interest) {
        return this.extendedUserRepository.addInterest(id, interest);
    }

    public List<String> removeInterest(UUID id, String interest) {
        return this.extendedUserRepository.removeInterest(id, interest);
    }
}
