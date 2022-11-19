package com.trackival.mdm.user.like.control;

import com.trackival.mdm.user.like.entity.Like;
import com.trackival.mdm.user.like.entity.LikeId;
import com.trackival.mdm.user.like.entity.LikeRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@AllArgsConstructor
public class LikeControl {
    private LikeRepository repository;

    public List<Like> findLikes(UUID eventId) {
        return this.repository.findLikesByEventId(eventId);
    }

    public List<Like> findLikedEvents(UUID userId) {
        return this.repository.findLikedEventsByUserId(userId);
    }

    public Like like(UUID userId, UUID eventId) {
        final Like like = Like.builder().id(LikeId.builder().userId(userId).eventId(eventId).build()).build();
        return this.repository.save(like);
    }

    public void unlike(UUID userId, UUID eventId) {
        final LikeId id = LikeId.builder().userId(userId).eventId(eventId).build();
        this.repository.deleteById(id);
    }
}
