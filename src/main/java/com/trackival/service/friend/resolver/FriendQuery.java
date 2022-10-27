package com.trackival.service.friend.resolver;

import com.trackival.service.friend.control.FriendControl;
import com.trackival.service.friend.entity.relation.FriendRelation;
import com.trackival.service.friend.entity.relation.FriendRelationRepository;
import com.trackival.service.friend.entity.request.FriendRequest;
import com.trackival.service.friend.entity.request.FriendRequestRepository;
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
