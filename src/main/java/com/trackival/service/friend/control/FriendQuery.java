package com.trackival.service.friend.control;

import com.trackival.service.friend.entity.relation.FriendRelation;
import com.trackival.service.friend.entity.relation.FriendRelationRepository;
import com.trackival.service.friend.entity.request.FriendRequest;
import com.trackival.service.friend.entity.request.FriendRequestRepository;
import graphql.kickstart.tools.GraphQLQueryResolver;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.UUID;

@Component
@RequiredArgsConstructor
public class FriendQuery implements GraphQLQueryResolver {
    private final FriendRequestRepository requestRepository;
    private final FriendRelationRepository relationRepository;

    public List<FriendRelation> fetchRelations(UUID id) {
        return this.relationRepository.findRelationsByUserId(id);
    }

    public List<FriendRequest> fetchIncomingRequests(UUID id) {
        return this.requestRepository.findRequestsByReceiverId(id);
    }
}
