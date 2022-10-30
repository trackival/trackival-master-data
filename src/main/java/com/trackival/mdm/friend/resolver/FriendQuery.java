package com.trackival.mdm.friend.resolver;

import com.trackival.mdm.friend.control.FriendControl;
import com.trackival.mdm.friend.entity.relation.FriendRelation;
import com.trackival.mdm.friend.entity.request.FriendRequest;
import graphql.kickstart.tools.GraphQLQueryResolver;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.UUID;

@Component
public class FriendQuery implements GraphQLQueryResolver {
    private FriendControl control;

    public List<FriendRelation> fetchRelations(UUID id) {
        return this.control.fetchRelations(id);
    }

    public List<FriendRequest> fetchIncomingRequests(UUID id) {
        return this.control.fetchIncomingRequests(id);
    }
}
