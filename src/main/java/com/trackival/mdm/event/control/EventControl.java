package com.trackival.mdm.event.control;

import com.trackival.mdm.address.Address;
import com.trackival.mdm.contact.Contact;
import com.trackival.mdm.event.dto.EventCreateInput;
import com.trackival.mdm.event.dto.EventPage;
import com.trackival.mdm.event.dto.EventUpdateInput;
import com.trackival.mdm.event.entity.Event;
import com.trackival.mdm.event.entity.EventRepository;
import com.trackival.mdm.event.exception.EventNotFoundException;
import com.trackival.mdm.user.control.UserControl;
import com.trackival.mdm.user.entity.User;
import lombok.AllArgsConstructor;
import org.jetbrains.annotations.NotNull;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@AllArgsConstructor
public class EventControl {
    private UserControl userControl;
    private EventMapper mapper;
    private EventRepository repository;

    public @NotNull Event findEvent(@NotNull UUID id) {
        return this.repository.findById(id).orElseThrow(() -> new EventNotFoundException(id));
    }

    public @NotNull Address findAddress(@NotNull UUID id) {
        return this.repository.findAddressById(id);
    }

    public @NotNull Contact findContact(@NotNull UUID id) {
        return this.repository.findContactById(id);
    }

    public @NotNull User findOrganizer(@NotNull UUID id) {
        return this.repository.findOrganizerById(id);
    }

    public Event createEvent(@NotNull EventCreateInput create) {
        final User organizer = this.userControl.findUser(create.getOrganizerId());
        final Event event = this.mapper.toEntity(create, organizer);
        return this.repository.save(event);
    }

    public @NotNull Event updateEvent(@NotNull UUID id, @NotNull EventUpdateInput update) {
        final Event event = this.findEvent(id);
        this.mapper.update(update, event);
        return this.repository.save(event);
    }

    public @NotNull EventPage fetchEvents(int page, int size) {
        final Page<Event> result = this.repository.findAll(PageRequest.of(page, size));
        final int current = result.getNumber();
        final int totalPages = result.getTotalPages();
        return EventPage.builder().totalPages(totalPages).page(current).events(result.getContent()).build();
    }

    public @NotNull EventPage fetchEventsByPosition(int page, int size, double longitude, double latitude, int distance) {
        return EventPage.empty();
    }
}
