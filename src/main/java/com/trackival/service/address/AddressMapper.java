package com.trackival.service.address;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface AddressMapper {
    Address toEntity(AddressInput address, double longitude, double latitude);

    @Mapping(target = "latitude", ignore = true)
    @Mapping(target = "longitude", ignore = true)
    Address toEntity(AddressInput address);
}
