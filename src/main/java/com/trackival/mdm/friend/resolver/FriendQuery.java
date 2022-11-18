package com.trackival.mdm.friend.resolver;

import com.netflix.graphql.dgs.*;
import com.trackival.mdm.friend.control.FriendControl;
import com.trackival.mdm.friend.entity.relation.FriendRelation;
import com.trackival.mdm.friend.entity.request.FriendRequest;
import com.trackival.mdm.user.control.UserControl;
import com.trackival.mdm.user.entity.User;
import lombok.AllArgsConstructor;
import org.jetbrains.annotations.NotNull;

import java.util.List;
import java.util.UUID;

@DgsComponent
@AllArgsConstructor
public class FriendQuery {
    private FriendControl control;
    private UserControl userControl;

    @DgsQuery
    public @NotNull List<@NotNull FriendRelation> fetchRelations(@InputArgument UUID id) {
        return this.control.fetchRelations(id);
    }

    @DgsQuery
    public @NotNull List<@NotNull FriendRequest> fetchIncomingRequests(@InputArgument UUID id) {
        return this.control.fetchIncomingRequests(id);
    }

    @DgsData(parentType = "FriendRelation")
    public @NotNull User friend1(DgsDataFetchingEnvironment environment) {
        final FriendRelation relation = environment.getSource();
        return this.userControl.findUser(relation.getId().getId1());
    }

    @DgsData(parentType = "FriendRelation")
    public @NotNull User friend2(DgsDataFetchingEnvironment environment) {
        final FriendRelation relation = environment.getSource();
        return this.userControl.findUser(relation.getId().getId2());
    }

    @DgsData(parentType = "FriendRequest")
    public @NotNull User sender(DgsDataFetchingEnvironment environment) {
        final FriendRequest request = environment.getSource();
        return this.control.findRequestSender(request.getId());
    }

    @DgsData(parentType = "FriendRequest")
    public @NotNull User receiver(DgsDataFetchingEnvironment environment) {
        final FriendRequest request = environment.getSource();
        return this.control.findRequestReceiver(request.getId());
    }
}
