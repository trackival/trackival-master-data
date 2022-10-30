package com.trackival.service.event.control;

import com.trackival.service.event.dto.EventCreateInput;
import com.trackival.service.event.dto.EventPage;
import com.trackival.service.event.dto.EventUpdateInput;
import com.trackival.service.event.entity.Event;
import com.trackival.service.event.entity.EventRepository;
import com.trackival.service.user.control.UserControl;
import com.trackival.service.user.entity.User;
import org.jetbrains.annotations.NotNull;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.UUID;

@Service
public class EventControl {
    private EventMapper mapper;
    private UserControl userControl;
    private EventRepository repository;

    public Event findEvent(@NotNull UUID id) {
        return this.repository.findById(id).orElseThrow();
    }

    public Event createEvent(@NotNull EventCreateInput create) {
        final User organizer = this.userControl.findUser(create.getOrganizerId());
        final Event event = this.mapper.toEntity(create, organizer);
        return this.repository.save(event);
    }

    public Event updateEvent(@NotNull UUID id, @NotNull EventUpdateInput update) {
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

    public @NotNull EventPage fetchEvents(int page, int size, double longitude, double latitude, int distance) {
        return EventPage.empty();
    }
}
