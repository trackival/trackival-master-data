package com.trackival.mdm.friend.resolver;

import com.trackival.mdm.friend.control.FriendControl;
import com.trackival.mdm.friend.entity.relation.FriendRelation;
import com.trackival.mdm.friend.entity.request.FriendRequest;
import graphql.kickstart.tools.GraphQLQueryResolver;
import lombok.AllArgsConstructor;
import org.jetbrains.annotations.NotNull;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.UUID;

@Component
@AllArgsConstructor
public class FriendQuery implements GraphQLQueryResolver {
    private FriendControl control;

    public @NotNull List<@NotNull FriendRelation> fetchRelations(@NotNull UUID id) {
        return this.control.fetchRelations(id);
    }

    public @NotNull List<@NotNull FriendRequest> fetchIncomingRequests(@NotNull UUID id) {
        return this.control.fetchIncomingRequests(id);
    }
}
