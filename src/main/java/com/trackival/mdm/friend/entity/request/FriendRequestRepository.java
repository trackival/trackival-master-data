package com.trackival.mdm.friend.entity.request;

import com.trackival.mdm.user.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface FriendRequestRepository extends JpaRepository<FriendRequest, UUID> {
    @Query("from FriendRequest request where request.receiver.id=:receiverId")
    List<FriendRequest> findRequestsByReceiverId(@Param("receiverId") UUID receiverId);

    @Query("select request.sender from FriendRequest request where request.id=:id")
    User findSenderById(@Param("id") UUID id);

    @Query("select request.receiver from FriendRequest request where request.id=:id")
    User findReceiverById(@Param("id") UUID id);
}
