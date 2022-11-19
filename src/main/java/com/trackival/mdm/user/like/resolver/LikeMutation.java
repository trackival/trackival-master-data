package com.trackival.mdm.user.like.resolver;

import com.netflix.graphql.dgs.DgsComponent;
import com.netflix.graphql.dgs.DgsMutation;
import com.netflix.graphql.dgs.InputArgument;
import com.trackival.mdm.user.like.control.LikeControl;
import com.trackival.mdm.user.like.entity.Like;
import lombok.AllArgsConstructor;

import java.util.List;
import java.util.UUID;

@DgsComponent
@AllArgsConstructor
public class LikeMutation {
    private LikeControl control;

    @DgsMutation
    public List<Like> like(@InputArgument UUID userId, @InputArgument UUID eventId) {
        this.control.like(userId, eventId);
        return this.control.findLikedEvents(userId);
    }

    @DgsMutation
    public List<Like> unlike(@InputArgument UUID userId, @InputArgument UUID eventId) {
        this.control.unlike(userId, eventId);
        return this.control.findLikedEvents(userId);
    }
}
