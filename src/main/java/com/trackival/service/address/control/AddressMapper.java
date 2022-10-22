package com.trackival.service.address.control;

import com.trackival.service.address.dto.AddressInput;
import com.trackival.service.address.entity.Address;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface AddressMapper {
    Address toEntity(AddressInput address);
}
