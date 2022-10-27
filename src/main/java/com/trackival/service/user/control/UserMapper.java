package com.trackival.service.user.control;

import com.trackival.service.address.AddressMapper;
import com.trackival.service.contact.ContactMapper;
import com.trackival.service.user.dto.UserRegistrationInput;
import com.trackival.service.user.dto.UserUpdateInput;
import com.trackival.service.user.entity.User;
import org.mapstruct.*;

import static org.mapstruct.NullValuePropertyMappingStrategy.IGNORE;

@Mapper(
        componentModel = "spring",
        unmappedTargetPolicy = ReportingPolicy.WARN,
        uses = {AddressMapper.class, ContactMapper.class}
)
public interface UserMapper {
    @Mapping(target = "biography", ignore = true)
    @Mapping(target = "contact", ignore = true)
    @Mapping(target = "interests", ignore = true)
    @Mapping(target = "settings", ignore = true)
    User toEntity(UserRegistrationInput registration);

    @Mapping(target = "user.id", ignore = true)
    @Mapping(target = "firstName", source = "firstName", nullValuePropertyMappingStrategy = IGNORE)
    @Mapping(target = "lastName", source = "lastName", nullValuePropertyMappingStrategy = IGNORE)
    @Mapping(target = "mail", source = "mail", nullValuePropertyMappingStrategy = IGNORE)
    @Mapping(target = "password", source = "password", nullValuePropertyMappingStrategy = IGNORE)
    @Mapping(target = "username", source = "username", nullValuePropertyMappingStrategy = IGNORE)
    @Mapping(target = "dateOfBirth", source = "dateOfBirth", nullValuePropertyMappingStrategy = IGNORE)
    @Mapping(target = "biography", source = "biography", nullValuePropertyMappingStrategy = IGNORE)
    @Mapping(target = "address", source = "address", nullValuePropertyMappingStrategy = IGNORE)
    @Mapping(target = "contact", source = "contact", nullValuePropertyMappingStrategy = IGNORE)
    @Mapping(target = "gender", source = "gender", nullValuePropertyMappingStrategy = IGNORE)
    @Mapping(target = "interests", ignore = true)
    @Mapping(target = "settings", ignore = true)
    User update(UserUpdateInput update, @MappingTarget User user);
}
