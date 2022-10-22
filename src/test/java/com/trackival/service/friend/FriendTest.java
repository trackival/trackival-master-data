package com.trackival.service.friend;

import com.trackival.service.Constants;
import com.trackival.service.friend.entity.relation.FriendRelation;
import com.trackival.service.friend.entity.relation.FriendRelationId;
import com.trackival.service.friend.entity.relation.FriendRelationRepository;
import com.trackival.service.user.control.UserMapper;
import com.trackival.service.user.entity.User;
import com.trackival.service.user.entity.UserRepository;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

@SpringBootTest
@ActiveProfiles("test")
class FriendTest {
    @Autowired
    private UserMapper mapper;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private FriendRelationRepository repository;

    /*
    @Test
    @Order(1)
    void persistence() {
        final User first = this.mapper.toEntity(Constants.USER_CREATE_INPUT);
        final User second = this.mapper.toEntity(Constants.USER_CREATE_INPUT);
        this.userRepository.save(first);
        this.userRepository.save(second);
        final FriendRelationId relationId = FriendRelationId.builder()
                .id1(first.getId())
                .id2(second.getId())
                .build();
        final FriendRelation relation = FriendRelation.builder()
                .friend1(first)
                .friend2(second)
                .id(relationId)
                .build();
        this.repository.save(relation);
        assertNotEquals(first.getId(), second.getId());

        //final List<FriendRelation> relationsByFirst = this.repository.findRelationsByUserId(first);
        //assertEquals(1, relationsByFirst.size());

        //final List<FriendRelation> relationsBySecond = this.repository.findRelationsByUserId(second);
        //assertEquals(1, relationsBySecond.size());
    }*/
}
