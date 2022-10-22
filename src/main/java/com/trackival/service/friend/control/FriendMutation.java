package com.trackival.service.friend.control;

import com.trackival.service.friend.entity.relation.FriendRelation;
import com.trackival.service.friend.entity.relation.FriendRelationId;
import com.trackival.service.friend.entity.relation.FriendRelationRepository;
import com.trackival.service.friend.entity.request.FriendRequest;
import com.trackival.service.friend.entity.request.FriendRequestRepository;
import com.trackival.service.user.entity.User;
import com.trackival.service.user.entity.UserRepository;
import graphql.kickstart.tools.GraphQLMutationResolver;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Optional;
import java.util.UUID;

@Component
@RequiredArgsConstructor
public class FriendMutation implements GraphQLMutationResolver {
    private final UserRepository userRepository;
    private final FriendRequestRepository requestRepository;
    private final FriendRelationRepository relationRepository;

    public FriendRelation acceptFriendRequest(UUID requestId) {
        final Optional<FriendRequest> requestOptional = this.requestRepository.findById(requestId);
        if (requestOptional.isEmpty()) {
            return null;
        }
        final FriendRequest request = requestOptional.get();
        final User receiver = request.getReceiver();
        final User sender = request.getSender();
        final FriendRelation relation = FriendRelation.builder()
                .friend1(receiver)
                .friend2(sender)
                .id(FriendRelationId.builder().id1(receiver.getId()).id2(sender.getId()).build())
                .build();
        return this.relationRepository.save(relation);
    }

    public FriendRequest sendFriendRequest(UUID senderId, UUID receiverId) {
        final User sender = this.userRepository.findById(senderId).orElseThrow();
        final User receiver = this.userRepository.findById(receiverId).orElseThrow();
        final FriendRequest request = FriendRequest.builder()
                .sender(sender)
                .receiver(receiver)
                .build();
        return this.requestRepository.save(request);
    }
}
