package com.trackival.mdm.contact.entity;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface ContactRepository extends JpaRepository<Contact, UUID> {
    @Query("select contact from Contact contact where contact.user is not null and contact.user.id=:userId")
    List<Contact> findUserContact(@Param("userId") UUID userId);

    @Query("select contact from Contact contact where contact.event is not null and contact.event.id=:eventId")
    List<Contact> findEventContact(@Param("eventId") UUID eventId);

    @Modifying
    @Query("delete from Contact contact where contact.contactKey=:key and contact.user is not null and contact.user.id=:userId")
    void deleteUserContact(@Param("userId") UUID userId, @Param("key") String key);

    @Modifying
    @Query("delete from Contact contact where contact.contactKey=:key and contact.event is not null and contact.event.id=:eventId")
    void deleteEventContact(@Param("eventId") UUID eventId, @Param("key") String key);
}
