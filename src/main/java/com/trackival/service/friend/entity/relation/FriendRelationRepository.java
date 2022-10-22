package com.trackival.service.friend.entity.relation;

import com.trackival.service.user.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.UUID;

public interface FriendRelationRepository extends JpaRepository<FriendRelation, FriendRelationId> {
    @Query("from FriendRelation relation where relation.friend1=:user or relation.friend2=:user")
    List<FriendRelation> findRelationsByUser(@Param("user") User user);

    @Query("from FriendRelation relation where relation.id.id1=:userId or relation.id.id2=:userId")
    List<FriendRelation> findRelationsByUserId(@Param("userId") UUID userId);

}
