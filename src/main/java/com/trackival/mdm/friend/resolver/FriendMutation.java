package com.trackival.mdm.friend.resolver;

import com.netflix.graphql.dgs.DgsComponent;
import com.netflix.graphql.dgs.DgsMutation;
import com.netflix.graphql.dgs.InputArgument;
import com.trackival.mdm.friend.control.FriendControl;
import com.trackival.mdm.friend.entity.relation.FriendRelation;
import com.trackival.mdm.friend.entity.request.FriendRequest;
import lombok.AllArgsConstructor;
import org.jetbrains.annotations.NotNull;
import org.springframework.stereotype.Component;

import java.util.UUID;

@DgsComponent
@AllArgsConstructor
public class FriendMutation {
    private FriendControl friendControl;

    @DgsMutation
    public @NotNull FriendRelation acceptFriendRequest(@InputArgument UUID requestId) {
        return this.friendControl.handleFriendRequestAcceptance(requestId);
    }

    @DgsMutation
    public @NotNull FriendRequest sendFriendRequest(@InputArgument UUID senderId, @InputArgument UUID receiverId) {
        return this.friendControl.handleFriendRequestSend(senderId, receiverId);
    }
}
