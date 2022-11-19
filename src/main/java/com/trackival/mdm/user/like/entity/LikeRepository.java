package com.trackival.mdm.user.like.entity;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface LikeRepository extends JpaRepository<Like, LikeId> {
    @Query("select l from Like l where l.id.eventId=:eventId")
    List<Like> findLikesByEventId(@Param("eventId") UUID eventId);

    @Query("select l from Like l where l.id.userId=:userId")
    List<Like> findLikedEventsByUserId(@Param("userId") UUID userId);
}
