package com.trackival.service.user.control;

import com.trackival.service.user.dto.UserRegistrationInput;
import com.trackival.service.user.entity.User;
import com.trackival.service.user.dto.UserCreateInput;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserMapper {
    User toEntity(UserRegistrationInput registration);
}
