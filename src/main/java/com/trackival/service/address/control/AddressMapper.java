package com.trackival.service.address.control;

import com.trackival.service.address.dto.AddressInput;
import com.trackival.service.address.entity.Address;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface AddressMapper {
    @Mapping(target = "latitude")
    @Mapping(target = "longitude")
    Address toEntity(AddressInput address, double longitude, double latitude);

    @Mapping(target = "latitude", ignore = true)
    @Mapping(target = "longitude", ignore = true)
    Address toEntity(AddressInput address);
}
