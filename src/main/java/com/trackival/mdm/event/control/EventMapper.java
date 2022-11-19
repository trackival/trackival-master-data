package com.trackival.mdm.event.control;

import com.trackival.mdm.address.AddressMapper;
import com.trackival.mdm.contact.ContactMapper;
import com.trackival.mdm.event.dto.EventCreateInput;
import com.trackival.mdm.event.dto.EventUpdateInput;
import com.trackival.mdm.event.entity.Event;
import com.trackival.mdm.user.entity.User;
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
    @Mapping(target = "likes", ignore = true)
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
    @Mapping(target = "likes", ignore = true)
    void update(EventUpdateInput update, @MappingTarget Event event);
}
