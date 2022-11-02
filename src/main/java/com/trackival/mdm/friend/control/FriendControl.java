package com.trackival.mdm.friend.control;

import com.trackival.mdm.friend.entity.relation.FriendRelationId;
import com.trackival.mdm.friend.entity.request.FriendRequest;
import com.trackival.mdm.friend.entity.relation.FriendRelation;
import com.trackival.mdm.friend.entity.relation.FriendRelationRepository;
import com.trackival.mdm.friend.entity.request.FriendRequestRepository;
import com.trackival.mdm.friend.exception.FriendRequestNotFoundException;
import com.trackival.mdm.user.control.UserControl;
import com.trackival.mdm.user.entity.User;
import lombok.AllArgsConstructor;
import org.jetbrains.annotations.NotNull;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@AllArgsConstructor
public class FriendControl {
    private UserControl userControl;
    private FriendRequestRepository requestRepository;
    private FriendRelationRepository relationRepository;

    public @NotNull FriendRelation handleFriendRequestAcceptance(@NotNull UUID requestId) {
        final FriendRequest request = this.requestRepository.findById(requestId)
                .orElseThrow(() -> new FriendRequestNotFoundException(requestId));
        final User receiver = request.getReceiver();
        final User sender = request.getSender();
        final FriendRelationId relationId = FriendRelationId.builder()
                .id1(receiver.getId())
                .id2(sender.getId())
                .build();
        final FriendRelation relation = FriendRelation.builder()
                .friend1(receiver)
                .friend2(sender)
                .id(relationId)
                .build();
        return this.relationRepository.save(relation);
    }

    public @NotNull FriendRequest handleFriendRequestSend(@NotNull UUID senderId, @NotNull UUID receiverId) {
        final User sender = this.userControl.findUser(senderId);
        final User receiver = this.userControl.findUser(receiverId);
        final FriendRequest request = FriendRequest.builder()
                .sender(sender)
                .receiver(receiver)
                .build();
        return this.requestRepository.save(request);
    }

    public @NotNull List<@NotNull FriendRelation> fetchRelations(@NotNull UUID id) {
        return this.relationRepository.findRelationsByUserId(id);
    }

    public @NotNull List<@NotNull FriendRequest> fetchIncomingRequests(@NotNull UUID id) {
        return this.requestRepository.findRequestsByReceiverId(id);
    }
}
