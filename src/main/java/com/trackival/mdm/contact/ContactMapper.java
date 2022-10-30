package com.trackival.mdm.contact;

import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ContactMapper {
    Contact toEntity(ContactInput input);
}
