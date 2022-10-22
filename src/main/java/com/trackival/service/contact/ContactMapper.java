package com.trackival.service.contact;

import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ContactMapper {
    Contact toEntity(ContactInput input);
}
