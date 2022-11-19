package com.trackival.mdm.user.like.resolver;

import com.netflix.graphql.dgs.*;
import com.trackival.mdm.event.entity.Event;
import com.trackival.mdm.user.entity.User;
import com.trackival.mdm.user.like.control.LikeControl;
import com.trackival.mdm.user.like.entity.Like;
import lombok.AllArgsConstructor;

import java.util.List;
import java.util.UUID;

@DgsComponent
@AllArgsConstructor
public class LikeQuery {
    private LikeControl control;

    @DgsQuery
    public List<Like> findLikedEvents(@InputArgument UUID userId) {
        return this.control.findLikedEvents(userId);
    }

    @DgsQuery
    public List<Like> findLikes(@InputArgument UUID eventId) {
        return this.control.findLikes(eventId);
    }

    @DgsData(parentType = "Event")
    public List<Like> likes(DgsDataFetchingEnvironment environment) {
        final Event event = environment.getSource();
        return this.control.findLikes(event.getId());
    }

    @DgsData(parentType = "User")
    public List<Like> likedEvents(DgsDataFetchingEnvironment environment) {
        final User user = environment.getSource();
        return this.control.findLikedEvents(user.getId());
    }
}
