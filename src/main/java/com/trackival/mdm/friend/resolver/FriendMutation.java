package com.trackival.mdm.friend.resolver;

import com.trackival.mdm.friend.control.FriendControl;
import com.trackival.mdm.friend.entity.relation.FriendRelation;
import com.trackival.mdm.friend.entity.request.FriendRequest;
import graphql.kickstart.tools.GraphQLMutationResolver;
import org.jetbrains.annotations.NotNull;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class FriendMutation implements GraphQLMutationResolver {
    private FriendControl friendControl;

    public @NotNull FriendRelation acceptFriendRequest(@NotNull UUID requestId) {
        return this.friendControl.handleFriendRequestAcceptance(requestId);
    }

    public @NotNull FriendRequest sendFriendRequest(@NotNull UUID senderId, @NotNull UUID receiverId) {
        return this.friendControl.handleFriendRequestSend(senderId, receiverId);
    }
}
