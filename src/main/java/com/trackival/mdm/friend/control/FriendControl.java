package com.trackival.mdm.friend.control;

import com.trackival.mdm.friend.entity.request.FriendRequest;
import com.trackival.mdm.friend.entity.relation.FriendRelation;
import com.trackival.mdm.friend.entity.relation.FriendRelationRepository;
import com.trackival.mdm.friend.entity.request.FriendRequestRepository;
import org.jetbrains.annotations.NotNull;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class FriendControl {
    private FriendRequestRepository requestRepository;
    private FriendRelationRepository relationRepository;

    public @NotNull List<@NotNull FriendRelation> fetchRelations(@NotNull UUID id) {
        return this.relationRepository.findRelationsByUserId(id);
    }

    public @NotNull List<@NotNull FriendRequest> fetchIncomingRequests(@NotNull UUID id) {
        return this.requestRepository.findRequestsByReceiverId(id);
    }
}
