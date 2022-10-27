package com.trackival.service.event.control;

import com.trackival.service.address.AddressMapper;
import com.trackival.service.contact.ContactMapper;
import com.trackival.service.event.dto.EventCreateInput;
import com.trackival.service.event.dto.EventUpdateInput;
import com.trackival.service.event.entity.Event;
import com.trackival.service.user.entity.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.ReportingPolicy;

import static org.mapstruct.NullValuePropertyMappingStrategy.IGNORE;

@Mapper(
        componentModel = "spring",
        unmappedTargetPolicy = ReportingPolicy.WARN,
        uses = {AddressMapper.class, ContactMapper.class}
)
public interface EventMapper {
    @Mapping(target = "address", source = "create.address")
    @Mapping(target = "contact", source = "create.contact")
    Event toEntity(EventCreateInput create, User organizer);

    @Mapping(target = "event.id", ignore = true)
    @Mapping(target = "event.organizer", ignore = true)
    @Mapping(target = "event.title", source = "update.title", nullValuePropertyMappingStrategy = IGNORE)
    @Mapping(target = "event.description", source = "update.description", nullValuePropertyMappingStrategy = IGNORE)
    @Mapping(target = "event.start", source = "update.start", nullValuePropertyMappingStrategy = IGNORE)
    @Mapping(target = "event.end", source = "update.end", nullValuePropertyMappingStrategy = IGNORE)
    @Mapping(target = "event.minimumAge", source = "update.minimumAge", nullValuePropertyMappingStrategy = IGNORE)
    @Mapping(target = "event.address", source = "update.address", nullValuePropertyMappingStrategy = IGNORE)
    @Mapping(target = "event.contact", source = "update.contact", nullValuePropertyMappingStrategy = IGNORE)
    @Mapping(target = "event.visibility", source = "update.visibility", nullValuePropertyMappingStrategy = IGNORE)
    void update(EventUpdateInput update, @MappingTarget Event event);
}
