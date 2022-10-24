package com.trackival.service.user.control;

import com.trackival.service.user.dto.UserRegistrationInput;
import com.trackival.service.user.entity.User;
import com.trackival.service.user.dto.UserCreateInput;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface UserMapper {
    @Mapping(target = "biography", ignore = true)
    @Mapping(target = "contact", ignore = true)
    @Mapping(target = "interests", ignore = true)
    @Mapping(target = "settings", ignore = true)
    User toEntity(UserRegistrationInput registration);
}
