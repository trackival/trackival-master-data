package com.trackival.mdm.event.entity;

import com.trackival.mdm.address.Address;
import com.trackival.mdm.user.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface EventRepository extends JpaRepository<Event, UUID> {
    @Query("select event.address from Event event where event.id=:id")
    Address findAddressById(@Param("id") UUID id);

    @Query("select event.organizer from Event event where event.id=:id")
    User findOrganizerById(@Param("id") UUID id);
}
